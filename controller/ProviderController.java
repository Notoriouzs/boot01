package com.hz.boot01.controller;

import com.hz.boot01.pojo.Provider;
import com.hz.boot01.service.ProviderService;
import com.hz.boot01.utils.JsonMassage;
import com.hz.boot01.utils.RedisUtil;
import com.hz.boot01.utils.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@Api(value = "供应商controller",tags = "供应商操作接口")
public class ProviderController {

    @Autowired
    @Getter
    @Setter
    private ProviderService providerService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    @ResponseBody
    public String redis(){
        //ValueOperations vo =redisTemplate.opsForValue();//操作字符串
        //vo.set("张三","吃屎");
//        redisTemplate.opsForValue().append("张三","吃屎");
//        System.out.println(redisTemplate.opsForValue().get("张三"));

        Provider provider = providerService.findProviderById(1);
//        RedisSerializer rs = new StringRedisSerializer();
        redisUtil.setStrJson("pro1",provider,1000L);
//        redisTemplate.setStringSerializer(rs);
//        ValueOperations ops = redisTemplate.opsForValue();
//        ops.set("pro",provider);//放入redis
        //取出对象

        return "成功";
    }
    @RequestMapping(value = "/deleteProviderById",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParam(name = "id", value = "根据id删除用户")
    @ApiOperation(value = "根据id删除用户",notes = "删除用户")
    public ResultJson deleteProviderById(Integer id){
        int i = providerService.deleteProviderById(id);    
        return new ResultJson(i);
    }


    @RequestMapping(value = "/updateProvider",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParam(name = "provider", value = "修改供应商")
    @ApiOperation(value = "修改供应商",notes = "修改供应商")
    public ResultJson updateProvider(Provider provider){
        int i = providerService.updateProvider(provider);
        System.out.println(i);
        return new ResultJson(i);
    }

    @RequestMapping(value = "/findProviderList",method = RequestMethod.GET)
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "proName",value = "根据名字查询")
            ,@ApiImplicitParam(name = "proDesc",value = "根据描述查询")})
    @ApiOperation(value = "根据名字和描述多条件组合查询并分页",notes = "查询和分页")
    public JsonMassage<List<Provider>> findProviderList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                        @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                                        String proName,
                                                        String proDesc
    ){
        List<Provider> list = providerService.findProviderList(page,limit,proName,proDesc);
        int count =providerService.findProviderCount();
        JsonMassage<List<Provider>> jsonMassage = new JsonMassage<List<Provider>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    @RequestMapping("/findProviderById/{id}")
    @ApiOperation(value = "根据id查找供应商",notes = "查找供应商")

    @ApiImplicitParam(name = "id",value = "根据id查找供应商")
    public String findProviderById(@PathVariable("id") Integer id, Model model){
        System.out.println(providerService.findProviderById(id).toString());
        model.addAttribute("pro",providerService.findProviderById(id));
        return "/page/edit";
    }
    @RequestMapping(value = "/addProvider",method =RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParam(name = "provider",value = "添加用户")
    @ApiOperation(value = "添加用户",notes = "添加用户")
    public JsonMassage addProvider(Provider provider){
        System.out.println(provider.toString());
        int i = providerService.addProvider(provider);
        JsonMassage jsonMassage = new JsonMassage();
        jsonMassage.setCode(i);
         if(i>0){
                jsonMassage.setMsg("添加成功");
         }else {
                jsonMassage.setMsg("添加失败");
         }
            return jsonMassage;
        }


}
