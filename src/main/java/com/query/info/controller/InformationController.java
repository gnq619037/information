package com.query.info.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.query.info.common.InfoResponse;
import com.query.info.dto.InformationDto;
import com.query.info.entity.Information;
import com.query.info.service.InformationService;
import com.query.info.util.CommUtil;
import com.query.info.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:44
 */
@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @RequiresPermissions("query")
    @PostMapping("/page")
    public InfoResponse<PageInfo<Information>> page(@RequestBody InformationDto informationDto){
        return informationService.listInformation(informationDto);
    }

    @RequiresPermissions("import")
    @PostMapping("/import")
    public InfoResponse<String> uploadInformation(@RequestParam(value = "file") MultipartFile file){
        try{
            String[] keys = {"codeBatch","expertCode","expertName","sex","birthDate","cardType","cardNumber","country","outside",
                    "cnName","insideHome","insideLiveReachDay","bankAccountName","bankCode","bankName","unionBankCode","telPhone","email",
                    "schoolCode","schoolName","payAmount","tax","realPayAmount","currentStatus","reviewNum","settlementStatus","failStatus",
                    "publishTime","publishBatch","publishResult","publishNum","fundType","infoFlag","backAccountVerify","publishFailMsg","publishFailUseFlag",
                    "pastBatch","messageStatus"};
            List<Map<String,String>> listData = ExcelUtil.getExcelData(file, "file",keys);
            System.out.println(JSONObject.toJSONString(listData));
            String dataJson = JSONObject.toJSONString(listData);
            List<Information> informationList = JSONArray.parseArray(dataJson, Information.class);
            return informationService.inputData(informationList);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new InfoResponse<String>().code(1);
    }

    @RequiresPermissions("export")
    @PostMapping("/export")
    public InfoResponse<String> exportInformation(@RequestBody InformationDto informationDto,
                                                  HttpServletRequest request, HttpServletResponse response){
        String fileName = CommUtil.formatTime("yyyyMMddHHmmss", new Date()) +".xls";
        List<Map<String, String>> dataList = informationService.queryData(informationDto);

        String[] keys = {"codeBatch","expertCode","expertName","sex","birthDate","cardType","cardNumber","country","outside",
                "cnName","insideHome","insideLiveReachDay","bankAccountName","bankCode","bankName","unionBankCode","telPhone","email",
                "schoolCode","schoolName","payAmount","tax","realPayAmount","currentStatus","reviewNum","settlementStatus","failStatus",
                "publishTime","publishBatch","publishResult","publishNum","fundType","infoFlag","backAccountVerify","publishFailMsg","publishFailUseFlag",
                "pastBatch","messageStatus"};
        String[] columnNames = {"费用批次",	"专家编号",	"专家姓名","性别", "出生年月", "证件类型", "证件号码", "国籍",
                "是否境外人员", "中文姓名（境外）",	"境内有无住所",	"境内是否居住满183天", "银行账户姓名", "银行账号", "开户行名称",
                "开户行联行号", "移动电话",	"电子信箱", "学校代码",	"学校名称",	"应发金额",	"税额",	"实发金额",	"当前状态",	"评审篇数",
                "结算状态",	"失败类型",	"发放时间",	"发放批次",	"发放结果",	"发放次数（上次）",	"经费类型",	"信息标记",	"银行开户验证状态（上次）",
                "发放失败原因", "银行发放用途标识",	"往期批次",	"消息状态"};
        try{
            Workbook wb = ExcelUtil.createWorkBook(dataList, keys, columnNames);
//            String savePath = request.getServletContext().getRealPath("/") + File.separator + fileName;
            // 创建文件流
            OutputStream stream = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename="+fileName+"");
//            response.setContentType("application/x-xls");
            response.setContentType("application/octet-stream");
            wb.write(stream);
            stream.close();


            //返回结果
            String downloadUrl = request.getScheme() + "://"+request.getServerName() + ":" +
                    request.getServerPort() + "/" + fileName;
            System.out.println("\n数据导出成功，下载路劲：" + downloadUrl);
            return null;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
