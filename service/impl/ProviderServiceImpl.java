package com.hz.boot01.service.impl;

import com.hz.boot01.dao.ProviderDao;
import com.hz.boot01.pojo.Provider;
import com.hz.boot01.service.ProviderService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired

    private ProviderDao providerDao;

    @Override
    public List<Provider> findProviderList(Integer page,
                                           Integer pageSize,
                                           String proName,
                                           String proDesc) {
        int pyl=(page-1)*pageSize;
        return  providerDao.findProviderList(pyl,pageSize,proName,proDesc);
    }

    @Override
    public Integer findProviderCount() {
        return providerDao.findProviderCount();
    }

    @Override
    public Provider findProviderById(Integer id) {

        return providerDao.findProviderById(id);
    }

    @Override
    public Integer addProvider(Provider provider) {
        return providerDao.addProvider(provider);
    }

    @Override
    public Integer updateProvider(Provider provider) {
        return providerDao.updateProvider(provider);
    }

    @Override
    public int deleteProviderById(Integer id) {
        return providerDao.deleteProviderById(id);
    }
}
