package vn.softech.util;

import java.util.Comparator;

import org.apache.log4j.Logger;

import vn.softech.dao.AdminSystemDao;
import vn.softech.hibernate.TblUrls;
public class UrlsComparator implements Comparator<TblUrls> {
	private static Logger log = Logger.getLogger(UrlsComparator.class);
	@Override
	public int compare(TblUrls arg0, TblUrls arg1) {
//		log.debug("call UrlsComparator::compare");
		if ((arg0.getParentId() != null) && (arg1.getParentId() != null) && (arg0.getParentId().equals(arg1.getParentId()))) {
			if (arg0.getPriority() == arg1.getPriority()) {
				return 0;
			} else if (arg0.getPriority() > arg1.getPriority()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 0;
/*
			if (arg0.getUrlsId() == arg1.getUrlsId()) {
				return 0;
			} else if (arg0.getUrlsId() > arg1.getUrlsId()) {
				return -1;
			} else {
				return 1;
			}
*/			
		}			
	}
}
