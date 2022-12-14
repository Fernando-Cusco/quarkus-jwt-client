package cusco.mejia.controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import cusco.mejia.model.ProductoItem;
import cusco.mejia.service.ProductoService;

@Path("/api/product")
@Consumes("application/json")
@Produces("application/json")
public class ProductoController {


    @Inject
    ProductoService productoService;

    @GET
    @PermitAll
    public Response products() {
        return Response.ok(productoService.getItems()).build();
    }

    @POST
    @RolesAllowed({"admin", "writer"})
    public Response addProduct(ProductoItem item) {
        productoService.addItem(item);
        return Response.ok(productoService.getItems()).build();
    }

    @Path("{id}")
    @DELETE
    @RolesAllowed({"admin"})
    public Response deleteProduct(@PathParam("id") Long id) {
        productoService.deleteItem(id);
        return Response.ok(productoService.getItems()).build();
    }
    
}
