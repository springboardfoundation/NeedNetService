package org.springboardfoundation.common.utiliy;

import java.net.URI;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class UriHelperUtils {
    /**
     * Returns a URI from the controller and paths E.g. uri =
     * createUriFrom(SomeController.class, "1234") returns
     * <p>
     * http://{hostname:port}/SomeController-URI-Path/1234
     *
     * @param clazz Controller class to create the URI root from
     * @param paths Paths to be added to the URI
     * @return URI
     */
    public static URI createUriFrom(Class clazz, Object... paths) {
	UriComponentsBuilder builder = WebMvcLinkBuilder.linkTo(clazz).toUriComponentsBuilder();
	for (Object path : paths) {
	    builder.pathSegment((String) path);
	}
	return builder.build().toUri();
    }

    public static URI createUriFrom(String baseUrl, Object... paths) {
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);
	for (Object path : paths) {
	    builder.pathSegment((String) path);
	}
	return builder.build().toUri();
    }

    public static String getUrlStringFromUri(URI uri) {
	return uri.getScheme() + uri.getHost() + uri.getPath();
    }
    
    public static URI getUriFromString(String uri) {
	return UriComponentsBuilder.fromHttpUrl(uri).build().toUri();
    }
}
