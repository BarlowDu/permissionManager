package com.barlow.permission.viewmodel;

import com.barlow.permission.model.Resource;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dtc on 2017/3/25.
 */
public class ResourceViewModel {
    private Resource item;
    private List<ResourceViewModel> children=new LinkedList<ResourceViewModel>();

    public ResourceViewModel(){}

    public ResourceViewModel(Resource resource){
        this.item=resource;
    }

    public Resource getItem() {
        return item;
    }

    public void setItem(Resource item) {
        this.item = item;
    }

    public List<ResourceViewModel> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceViewModel> children) {
        this.children = children;
    }
}
