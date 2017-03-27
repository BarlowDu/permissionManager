package com.barlow.permission;

import com.barlow.permission.dao.ResourceDao;
import com.barlow.permission.viewmodel.ResourceViewModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dutc on 2017/3/27.
 */
@Service
public class ResourceService {
    @Resource
    private ResourceDao resourceDao;

    public List<ResourceViewModel> getMenu(){

        ResourceViewModel root=new ResourceViewModel();

        root.setItem(new com.barlow.permission.model.Resource());
        root.getItem().setId(0);
        List<com.barlow.permission.model.Resource> sources=resourceDao.selectAll();
        getMenu(sources,root);
        return root.getChildren();
    }

    private void getMenu(List<com.barlow.permission.model.Resource> sources,ResourceViewModel parent){
        for(int i=0;i<sources.size();i++){
            if(sources.get(i).getParent_id()==parent.getItem().getId()){
                ResourceViewModel child=new  ResourceViewModel(sources.get(i));
                parent.getChildren().add(child);
                getMenu(sources,child);
            }
        }
    }
}
