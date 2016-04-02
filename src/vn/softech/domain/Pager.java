package vn.softech.domain;

public class Pager {
	private int page;
	private int totalPage;
	private int rowOfPage;
    private int results;
    private String sortOrder;
    private String sortColumn;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRowOfPage() {
		return rowOfPage;
	}
	public void setRowOfPage(int rowOfPage) {
		this.rowOfPage = rowOfPage;
	}

}
