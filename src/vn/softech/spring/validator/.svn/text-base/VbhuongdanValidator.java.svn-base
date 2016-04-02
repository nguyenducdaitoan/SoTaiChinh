package vn.softech.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.softech.hibernate.TblVbHuongDan;


public class VbhuongdanValidator implements Validator {
	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return TblVbHuongDan.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
//				"required.userName", "Field name is required   545454.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
//				"required.address", "Field name is required.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//				"required.password", "Field name is required.");
//			
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
//				"required.confirmPassword", "Field name is required.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", 
//				"required.sex", "Field name is required.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber", 
//				"required.favNumber", "Field name is required.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(
//				errors, "javaSkills", "required.javaSkills","Field name is required.");
		
		TblVbHuongDan vbhuongdan = (TblVbHuongDan)target;
		
		if(vbhuongdan.getTitle().length()==0){
			errors.rejectValue("title", "NotEmpty.vbhuongdan.title");
		}
		if(vbhuongdan.getSummary().length()==0){
			errors.rejectValue("summary", "NotEmpty.vbhuongdan.summary");
		}
		if(vbhuongdan.getContent().length()==0){
			errors.rejectValue("content", "NotEmpty.vbhuongdan.content");
		}

//		if("NONE".equals(cust.getCountry())){
//			errors.rejectValue("country", "required.country");
//		}
		
		
	}

}
