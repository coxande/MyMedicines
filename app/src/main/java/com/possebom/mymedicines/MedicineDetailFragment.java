package com.possebom.mymedicines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.possebom.mymedicines.dao.MedicineDao;
import com.possebom.mymedicines.model.Medicine;

public class MedicineDetailFragment extends Fragment {
	public static final String		ARG_ITEM_ID	= "item_id";
	private Medicine medicine;

	public MedicineDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			long id = getArguments().getLong(ARG_ITEM_ID);
			medicine = MedicineDao.getInstance(getActivity()).getMedicineById(id);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_medicine_detail, container, false);
		if (medicine != null) {
			((TextView) rootView.findViewById(R.id.medicine_detail_brandName)).setText(medicine.getBrandName());
			((TextView) rootView.findViewById(R.id.medicine_detail_drug)).setText(medicine.getDrug());
			((TextView) rootView.findViewById(R.id.medicine_detail_validity)).setText(medicine.getValidity());
			((TextView) rootView.findViewById(R.id.medicine_detail_laboratory)).setText(medicine.getLaboratory());
			((TextView) rootView.findViewById(R.id.medicine_detail_form)).setText(medicine.getForm());
			((TextView) rootView.findViewById(R.id.medicine_detail_concentration)).setText(medicine.getConcentration());
		}
		return rootView;
	}
}
