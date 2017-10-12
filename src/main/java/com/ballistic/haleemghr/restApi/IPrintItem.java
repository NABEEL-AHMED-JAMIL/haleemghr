package com.ballistic.haleemghr.restApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * Created by Nabeel on 10/10/2017.
 */
@Api(value="Print-Item", description="Print-Item Operation handling")
public interface IPrintItem {

    String Path = "/{printName}";
    String PRINT_LIST = "/getPrint_List";

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @ApiOperation(value = "Get Printer List..... Detail")
    List<String> getPrinterList();

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @ApiOperation(value = "Get Print Response..... Detail")
    ResponseEntity<?> getPrintResponse(@PathVariable String printName, @RequestBody String bill);

}
