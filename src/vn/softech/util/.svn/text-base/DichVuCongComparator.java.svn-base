package vn.softech.util;

import java.util.Comparator;

import vn.softech.bean.DichVuCongBean;

public class DichVuCongComparator implements Comparator<DichVuCongBean> {

	@Override
	public int compare(DichVuCongBean arg0, DichVuCongBean arg1) {
		if (arg0.getNgayGoi().equals(arg1.getNgayGoi())) {
			return 0;
		} else {
			if (arg0.getNgayGoi().before(arg1.getNgayGoi())) {
				return -1;
			} else {
				return 1;
			}
		}
			
	}

}
