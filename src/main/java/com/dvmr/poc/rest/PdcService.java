package com.dvmr.poc.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dvmr.poc.bean.FileBean;
import com.dvmr.poc.exception.NotFoundException;
import com.dvmr.poc.service.BlobService;
import com.dvmr.poc.service.impl.BlobServiceImpl;
import com.dvmr.poc.util.MultipartUtil;

/**
 * This rest based document service
 * @author vreddy.fp
 *
 */

@Path("/")
public class PdcService {

	/**
	 * Replace with Inject annotation in JEE6 or with Spring 3.0
	 */
	private final BlobService blobService = new BlobServiceImpl();

	public PdcService() {
		super();
	}
	
	public BlobService getBlobService() {
		return blobService;
	}


	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadFile(@Context HttpServletRequest request,
			@Context HttpServletResponse res) throws Exception {
		String response = "Unable to attach files";
		FileBean bean = MultipartUtil.parseMultipart(request, getBlobService());
		if (null != bean) {
			response = "{\"name\":\"" + bean.getFilename() + "\",\"type\":\""
			+ bean.getContentType() + "\",\"size\":\"" + bean.getSize()
			+ "\"}";
		}
		return Response.ok(response).build();
	}

	
	/**
	 * In Memory solution
	 * 
	 * @param blobKey
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("image")
	@Produces("image/jpg")
	public Response downloadFile(
			@DefaultValue("empty") @QueryParam(value = "blobKey") String blobKey)
			throws Exception {
		if(blobKey.equals("empty"))
			throw new NotFoundException("blobKey cannot be empty!");
		
		byte[] docStream = getBlobService().getBlob(blobKey);
		return Response
				.ok(docStream).build();
	}
	
}
