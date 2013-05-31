package com.dvmr.poc.service;

import java.io.InputStream;
import java.util.List;

import com.dvmr.poc.bean.FileBean;

public interface BlobService {
	/**
	 * upload files to a directory
	 * @param inputStream
	 * @param filename
	 * @return
	 */
	public long uploadBlob(InputStream inputStream, String filename);
	/**
	 * returns the file as a byte[]
	 * @param blobKey
	 * @return
	 */
	public byte[] getBlob(String blobKey);
	
	/**
	 * Deletes file form the directory
	 * @param blobKey
	 */
	public void deleteBlob(String blobKey);
	
	/**
	 * get all files from the directory
	 * @return
	 */
	public List<FileBean> getBlobs();
}
