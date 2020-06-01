package com.demo.api;

import com.demo.dao.ProductDAO;
import com.demo.entity.Product;
import com.demo.model.Messages;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("/products")
public class ProductService {
    @EJB
    ProductDAO dao;

    @GET
    @Produces("application/json")
    public List<Product> getProduct()
    {
        return dao.getProduct();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Messages createProduct(Product p)
    {
        int success = dao.insertProduct(p);
        Messages mes = new Messages();
        if(success>0)
        {
            mes.setStatus(1);
            mes.setMessage("Success");
        }
        else
        {
            mes.setStatus(0);
            mes.setMessage("Fail");
        }
        return mes;
    }

    @PUT
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Messages updateProduct(@PathParam("id") int id, Product p)
    {
        int success = dao.updateProduct(id,p);
        Messages mes = new Messages();
        if(success>0)
        {
            mes.setStatus(1);
            mes.setMessage("Success");
        }
        else
        {
            mes.setStatus(0);
            mes.setMessage("Fail");
        }
        return mes;
    }

}
