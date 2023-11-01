package com.cn.offline.contoller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.auth.config.Authentication;
import com.cn.offline.config.OfflineAuthMenuKeyConstant;
import com.cn.offline.config.OfflineFilePathOnlineConfig;
import com.cn.offline.entity.OfflineCountryDo;
import com.cn.offline.service.impl.GoodFirstMeumServiceImpl;
import com.cn.offline.service.impl.OfflineCountryServiceImpl;
import com.pub.core.util.controller.BaseController;
import com.pub.core.util.domain.AjaxResult;
import com.pub.core.util.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单表 (EIP) 前端控制器
 * </p>
 *
 * @author ganyongheng
 * @since 2023-08-11
 */
@Controller
@RequestMapping("/offline/offlineCountryDo")
public class OfflineCountryController extends BaseController {

    @Autowired
    private OfflineCountryServiceImpl offlineCountryServiceImpl;

    @Autowired
    private OfflineFilePathOnlineConfig filePathOnlineConfig;

    @Autowired
    private GoodFirstMeumServiceImpl goodFirstMeumServiceImpl;
    /**
     * @return
     */
    @RequestMapping(value = "/addCountryDo", method = RequestMethod.POST)
    @ResponseBody
    @Authentication(menu = OfflineAuthMenuKeyConstant.SELL_GIFT_COUNTRY)
    public AjaxResult addCountryDo(@RequestBody OfflineCountryDo req){
        try{
            QueryWrapper<OfflineCountryDo> wq=new QueryWrapper<>();
            wq.eq("country_name",req.getCountryName());
            OfflineCountryDo one = offlineCountryServiceImpl.getOne(wq);
            if(one!=null){
                return AjaxResult.error("重复国家名称！");
            }
            req.setCreateTime(new Date());
            String imageUrl = req.getImageUrl();
            String[] split = imageUrl.split(filePathOnlineConfig.getBaseUrl());
            if(split.length>1){
                req.setImageUrl(split[1]);
            }else{
                req.setImageUrl(split[0]);
            }
            offlineCountryServiceImpl.save(req);
            goodFirstMeumServiceImpl.putFirstDataRedis();
            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 分页数据
     * @param req
     * @return
     */
    @RequestMapping(value = "/getPageList", method = RequestMethod.POST)
    @ResponseBody
    @Authentication(menu = OfflineAuthMenuKeyConstant.SELL_GIFT_COUNTRY)
    public AjaxResult getPageList(@RequestBody OfflineCountryDo req){
        try{
            List<OfflineCountryDo> pageList = offlineCountryServiceImpl.getPageList(req);
            TableDataInfo dataTable = getDataTable(pageList);
            return AjaxResult.success(dataTable);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }
    /**
     *删除
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    @Authentication(menu = OfflineAuthMenuKeyConstant.SELL_GIFT_COUNTRY)
    public AjaxResult delete(@RequestParam Integer id){
        try{
            offlineCountryServiceImpl.removeById(id);
            goodFirstMeumServiceImpl.putFirstDataRedis();
            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }
}

