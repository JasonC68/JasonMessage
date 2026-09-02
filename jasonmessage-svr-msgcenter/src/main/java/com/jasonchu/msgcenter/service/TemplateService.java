package com.jasonchu.msgcenter.service;

import com.jasonchu.msgcenter.model.TemplateModel;

public interface TemplateService {

    String CreateTemplate(TemplateModel templateModel);

    void DeleteTemplate(String templateID);

    void UpdateTemplate(TemplateModel templateModel);

    TemplateModel GetTemplate(String templateID);

    TemplateModel GetTemplateWithCache(String templateID);
}
