package cn.test.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonGenerator;

@Configuration
public class JsonpConfig {
	@Bean
	public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter() {
			// 做jsonp的支持的标识，在请求参数中加该参数
			private final static String CALLBACK = "callback";

			// 获取callback参数
			private String parseCallbackParam() {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
						.currentRequestAttributes()).getRequest();
				return request.getParameter(CALLBACK);
			}

			@Override
			protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
				String callback = parseCallbackParam();
				if (!StringUtils.isEmpty(callback))
					generator.writeRaw(callback + "(");
			}

			@Override
			protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
				String callback = parseCallbackParam();
				if (!StringUtils.isEmpty(callback))
					generator.writeRaw(")");
			}
		};
	}
}