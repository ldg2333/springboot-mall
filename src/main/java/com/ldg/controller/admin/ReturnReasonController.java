package com.ldg.controller.admin;

import com.ldg.entity.ReturnReason;
import com.ldg.service.ReturnReasonService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("returnReason")
@CrossOrigin
public class ReturnReasonController {

    @Autowired
    private ReturnReasonService returnReasonService;

    @GetMapping("/getAllReason")
    public ResultInfo getAllReason(){
        try {
            List<String> list = returnReasonService.selectAllName();
            return ResultInfo.success("查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @GetMapping("/getAllReasonNoWithState")
    public ResultInfo getAllReasonNoWithState(String reasonName){
        try {
            List<ReturnReason> list = returnReasonService.selectAll(reasonName);
            return ResultInfo.success("查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @PostMapping("/updateReasonState")
    public ResultInfo updateReasonState(@RequestBody ReturnReason returnReason){
        try {
            if(returnReasonService.updateById(returnReason))
                return ResultInfo.success("修改成功");
            return ResultInfo.success("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("修改失败");
        }
    }

    @PostMapping("/addReason")
    public ResultInfo addReason(@RequestBody ReturnReason returnReason){
        try {
            if(returnReasonService.insertData(returnReason))
                return ResultInfo.success("新增成功");
            return ResultInfo.success("新增失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("新增失败");
        }
    }

    @DeleteMapping("/deleteReason")
    public ResultInfo deleteReason(Integer reasonId){
        try {
            if(returnReasonService.deleteById(reasonId))
                return ResultInfo.success("删除成功");
            return ResultInfo.success("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("删除失败");
        }
    }
}
