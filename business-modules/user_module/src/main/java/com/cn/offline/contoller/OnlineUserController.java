package com.cn.offline.contoller;


import com.cn.auth.config.Authentication;
import com.cn.offline.config.OfflineAuthMenuKeyConstant;
import com.cn.offline.entity.OnlineOrderInfoDo;
import com.cn.offline.entity.OnlineUserDo;
import com.cn.offline.entity.OnlineWithdrawDo;
import com.cn.offline.service.impl.OnlineUserServiceImpl;
import com.pub.core.util.controller.BaseController;
import com.pub.core.util.domain.AjaxResult;
import com.pub.core.util.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 在线用户表 前端控制器
 * </p>
 *
 * @author ganyongheng
 * @since 2023-07-31
 */
@Controller
@RequestMapping("/offline/onlineUserDo")
public class OnlineUserController extends BaseController {

    @Autowired
    private OnlineUserServiceImpl onlineUserServiceImpl;

    /**
     * 查看用户的分页数据
     * @return
     */
    @RequestMapping(value = "/getPageList", method = RequestMethod.POST)
    @ResponseBody
    @Authentication(menu = OfflineAuthMenuKeyConstant.BASE_CUSTOM)
    public AjaxResult getPageList(@RequestBody OnlineUserDo onlineUserDo){
        try{
            List<OnlineUserDo> pageList = onlineUserServiceImpl.getPageList(onlineUserDo);
            TableDataInfo dataTable = getDataTable(pageList);
            return AjaxResult.success(dataTable);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }
    /**
     *设置黑名单
     * @return
     */
    @RequestMapping(value = "/setBlack", method = RequestMethod.POST)
    @ResponseBody
    @Authentication(menu = OfflineAuthMenuKeyConstant.BASE_CUSTOM)
    public AjaxResult setBlack(@RequestBody OnlineUserDo onlineUserDo){
        try{
            onlineUserServiceImpl.setBlack(onlineUserDo);
            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }
    /**
     *查看交易明细
     * @return
     */
    @RequestMapping(value = "/getDraw", method = RequestMethod.POST)
    @ResponseBody
    @Authentication(menu = OfflineAuthMenuKeyConstant.BASE_CUSTOM)
    public AjaxResult getDraw(@RequestParam Integer userId){
        try{
            List<OnlineWithdrawDo> pageList = onlineUserServiceImpl.getDraw(userId);
            TableDataInfo dataTable = getDataTable(pageList);
            return AjaxResult.success(dataTable);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }
    /**
     *查看订单
     * @return
     */
    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    @ResponseBody
    @Authentication(menu = OfflineAuthMenuKeyConstant.BASE_CUSTOM)
    public AjaxResult getOrder(@RequestParam Integer userId){
        try{
            List<OnlineOrderInfoDo> order = onlineUserServiceImpl.getOrder(userId);
            TableDataInfo dataTable = getDataTable(order);
            return AjaxResult.success(dataTable);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }

}

