package com.zaga.resource;

import com.zaga.entity.CarEnum;
import com.zaga.entity.CarServiceDetails;
import com.zaga.service.CarServiceService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/v1/car-management")
public class CarServiceResource {

    @Inject
    CarServiceService service;

    @POST
    @Path("/create-car_details")
    public Response createDetails(CarServiceDetails details) {
        try {
            return Response.status(200).entity(service.createCarServiceDetails(details)).build();

        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();

        }
    }

    @GET
    @Path("/view-car_details")
    public Response viewCarServiceDetails(@QueryParam("carNumber") String carNumber,
            @QueryParam("customerName") String customerName) {
        try {
            return Response.status(200).entity(service.viewCarDetails(carNumber, customerName)).build();

        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();

        }

    }

    @PUT
    @Path("/modify-car-details")
    public Response modifyCarDetailsByStatus(@QueryParam("carNumber") String carNumber,
            @QueryParam("customerName") String customerName, @QueryParam("serviceStatus") CarEnum serviceStatus) {
        try {
            return Response.status(201).entity(service.modifyCarDetails(carNumber, customerName, serviceStatus))
                    .build();

        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();

        }

    }

    @DELETE
    @Path("/delete-car-details")
    public Response deleteDetailsByDeliveryStatus(@QueryParam("deliveredStatus") boolean deliveredStatus) {
        try {
            return Response.status(204).entity(service.deleteCarDetails(deliveredStatus)).build();

        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();

        }
    }

}
