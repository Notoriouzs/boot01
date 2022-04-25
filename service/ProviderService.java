package com.hz.boot01.service;

import com.hz.boot01.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供应商业务接口
 */
public interface ProviderService {



    public List<Provider> findProviderList(Integer page,
                                           Integer pageSize,
                                           String proName,
                                           String proDesc


    );

    public Integer findProviderCount();
    /**
     * 根据ID  获得供应商对象
     * @param id
     * @return
     */
    public Provider findProviderById(Integer id);

    /**
     *
     * @param provider
     * @return
     */
    public Integer addProvider(Provider provider);

    /**
     *
     * @param provider
     * @return
     */

    public Integer updateProvider(Provider provider);

    /**
     *
     * @param id
     * @return
     */
    public int deleteProviderById(Integer id);
}
