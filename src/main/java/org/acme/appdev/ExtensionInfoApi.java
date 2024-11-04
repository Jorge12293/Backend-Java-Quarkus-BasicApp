package org.acme.appdev;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Produces;


@Path("/extensions")
public class ExtensionInfoApi {
    
    @Inject
    ExtensionInfo extensionInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<JsonObject> getExtensions() {
        Set<JsonObject> collect = extensionInfo.doSomething().stream().map(extension -> {
            JsonObject json = Json.createObjectBuilder()
                    .add("id", extension.id)
                    .add("name", extension.name)
                    .add("shortName", extension.shortName)
                    .add("keywords", Json.createArrayBuilder(extension.keywords))
                    .build();
            return json;
        }).collect(Collectors.toSet());
        return collect;
    }

}
