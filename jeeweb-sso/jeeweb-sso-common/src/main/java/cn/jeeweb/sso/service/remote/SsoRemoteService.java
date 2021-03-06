package cn.jeeweb.sso.service.remote;

import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.sso.SsoConstants;
import cn.jeeweb.sso.config.SsoProperties;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hexin on 2018/9/12.
 */
public class SsoRemoteService {
    RestTemplate restTemplate;
    SsoProperties ssoProperties;

    public SsoRemoteService(RestTemplate restTemplate,SsoProperties ssoProperties){
        this.restTemplate = restTemplate;
        this.ssoProperties = ssoProperties;
    }

    public AjaxJson parseToken(String token,String clientUrl){
        String ssoServiceUrl = ssoProperties.getSsoServiceUrl()+ SsoConstants.URL_PARSE_TOKEN +"?"+SsoConstants.PARAMETER_TOKEN + "=" +token +"&" + SsoConstants.PARAMETER_CLIENT_URL+"="+clientUrl;
        return restTemplate.postForObject(ssoServiceUrl,null, AjaxJson.class);
    }
}