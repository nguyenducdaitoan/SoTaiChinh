package vn.softech.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vn.softech.hibernate.TblLdCap;
import vn.softech.hibernate.TblLdCoQuan;
import vn.softech.hibernate.TblLdLinhVuc;
import vn.softech.hibernate.TblLdLoaiVb;
import vn.softech.hibernate.TblVbHanhChinh;

public class VbHanhChinhForm extends TblVbHanhChinh{
	
	short ldCapId;
	short ldCoQuanId;
	short ldLinhVucId;
	short ldLoaiVbId;
	
	private String query;
    private String tuNgay;
    private String denNgay;
    private int rowOfPage;
    private int totalPage;
    private int page;
    private int totalRecord;
    private String ngaybanhanh;
    private String ngayhieuluc;
    
        
    private List<TblLdCap> listLdCap = new ArrayList<TblLdCap>();
    private List<TblLdLoaiVb> listLdLoaiVb = new ArrayList<TblLdLoaiVb>();
    private List<TblLdCoQuan> listLdCoQuan = new ArrayList<TblLdCoQuan>();
    private List<TblLdLinhVuc> listLdLinhVuc = new ArrayList<TblLdLinhVuc>();
    private List<TblVbHanhChinh> listVbHanhchinh = new ArrayList<TblVbHanhChinh>();
	
    
    
    public String getNgaybanhanh() {
		return ngaybanhanh;
	}
	public void setNgaybanhanh(String ngaybanhanh) {
		this.ngaybanhanh = ngaybanhanh;
	}
	public String getNgayhieuluc() {
		return ngayhieuluc;
	}
	public void setNgayhieuluc(String ngayhieuluc) {
		this.ngayhieuluc = ngayhieuluc;
	}
	private MultipartFile dulieu;
       	
	public MultipartFile getDulieu() {
		return dulieu;
	}
	public void setDulieu(MultipartFile dulieu) {
		this.dulieu = dulieu;
	}
	public List<TblLdCap> getListLdCap() {
		return listLdCap;
	}
	public void setListLdCap(List<TblLdCap> listLdCap) {
		this.listLdCap = listLdCap;
	}
	public List<TblLdLoaiVb> getListLdLoaiVb() {
		return listLdLoaiVb;
	}
	public void setListLdLoaiVb(List<TblLdLoaiVb> listLdLoaiVb) {
		this.listLdLoaiVb = listLdLoaiVb;
	}
	public List<TblLdCoQuan> getListLdCoQuan() {
		return listLdCoQuan;
	}
	public void setListLdCoQuan(List<TblLdCoQuan> listLdCoQuan) {
		this.listLdCoQuan = listLdCoQuan;
	}
	public List<TblLdLinhVuc> getListLdLinhVuc() {
		return listLdLinhVuc;
	}
	public void setListLdLinhVuc(List<TblLdLinhVuc> listLdLinhVuc) {
		this.listLdLinhVuc = listLdLinhVuc;
	}
	
	public List<TblVbHanhChinh> getListVbHanhchinh() {
		return listVbHanhchinh;
	}
	public void setListVbHanhchinh(List<TblVbHanhChinh> listVbHanhchinh) {
		this.listVbHanhchinh = listVbHanhchinh;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getTuNgay() {
		return tuNgay;
	}
	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}
	public String getDenNgay() {
		return denNgay;
	}
	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}
	public int getRowOfPage() {
		return rowOfPage;
	}
	public void setRowOfPage(int rowOfPage) {
		this.rowOfPage = rowOfPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public short getLdCapId() {
		return ldCapId;
	}
	public void setLdCapId(short ldCapId) {
		this.ldCapId = ldCapId;
	}	
	
	public short getLdLinhVucId() {
		return ldLinhVucId;
	}
	public void setLdLinhVucId(short ldLinhVucId) {
		this.ldLinhVucId = ldLinhVucId;
	}
	public short getLdLoaiVbId() {
		return ldLoaiVbId;
	}
	public void setLdLoaiVbId(short ldLoaiVbId) {
		this.ldLoaiVbId = ldLoaiVbId;
	}
	public short getLdCoQuanId() {
		return ldCoQuanId;
	}
	public void setLdCoQuanId(short ldCoQuanId) {
		this.ldCoQuanId = ldCoQuanId;
	}
	

}
