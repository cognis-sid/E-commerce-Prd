package com.rclgroup.dolphin.ezl.email;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.BookingConfirmationMail;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EsiSubmissionMail;
import com.rclgroup.dolphin.rcl.web.getRate.actionForm.GetRateUim;

public class EZLMail {
	private String adminEmail;

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	private MailSender mailSender;

	private JavaMailSender javaMailSender;
	private VelocityEngine velocityEngine;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public VelocityEngine getVelocityEngine() {
		return this.velocityEngine;
	}

	public void sendMail(String from, String to, String subject, String msg) {
		// creating message
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		// sending message
		mailSender.send(message);
	}

	public void sendBookingConfirmationEmail(final EserviceNewWebBookingUim bookingConfirm) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				String subject = "(" + bookingConfirm.getCustomerName()
						+ " / <<contract_party_name>>) Booking  Confirmed! <<bkg_number_hyphen>> "
						+ bookingConfirm.getBookingNo();
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(bookingConfirm.getEmail());
				message.setSubject(subject);
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("bookingConfirm", bookingConfirm);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/booking_confirmation_email_template.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

	public void sendMailForRegistrationConfirmation(EserviceRegistrationUim form,String allSFUCodeChecked) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				System.out.println("sendMailForRegistrationConfirmatio() ....called.. ");
				String subject = "Welcome TO RCL eServices www.rclgroup.com";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(form.getReEmailAddress()));
				message.setSubject(subject);
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("Registered", form);
				model.put("allSFUCodeChecked", allSFUCodeChecked);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/RegistrationApproveMail.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}
	
	public void sendMailForRegistrationConfirmationPic(EserviceRegistrationUim form,String allSFUCodeChecked,String representedCompany) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				System.out.println("sendMailForRegistrationConfirmatio() ....called.. ");
				String subject = "Approval pending: "+form.getUserInfoMod().getCmpName()+" - Customer request for RCL eServices";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(form.getToPicMail()));
				if(form.getCcPicMail()!=null && !"".equalsIgnoreCase(form.getCcPicMail())  ){
					message.setCc(getMailId(form.getCcPicMail()));
					}
				if( form.getBccPicMail()!=null && !"".equalsIgnoreCase(form.getBccPicMail()) ){
					message.setBcc(getMailId(form.getBccPicMail()));
					}
				message.setSubject(subject);
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("Registered", form);
				model.put("allSFUCodeChecked", allSFUCodeChecked);
				model.put("customerMail", form.getUserInfoMod().getEmail());
				model.put("representedCompany", representedCompany);
				model.put("companynmae" , form.getUserInfoMod().getCmpName());
				model.put("telephone" , form.getUserInfoMod().getPhoneNo());
				model.put("fax" , form.getUserInfoMod().getFaxNo());
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/registrationRequestPicMail.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

	public void bookingSubmitionMail(EserviceNewWebBookingUim form,String repCompanyName,String bookingPartyComName) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				System.out.println("bookingSubmitionMail() called.." + form.getBookingNo()+" "+form.getEmail());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String cuuntDate = formatter.format(date);
				String subject = "";
				String [] commodity=form.getCargoDescription().split("\r\n");
				for(int i=0;i<commodity.length;i++) {
					if(i==0)
						form.setShipper_Name_comm(commodity[i]);
					else if(i==1)
						form.setCommodity_Mail(commodity[i]);
					else if(i==2)
						form.setHs_Code(commodity[i]);
					else if(i==3)
						form.setCondition_Of_Container(commodity[i]);
				}
				if (form.getStatus().equals("Confirmed")) {
					subject = form.getPodNmae() + "-" + form.getBookingRef()  
							+ " - "+bookingPartyComName +" - "+ repCompanyName+" Booking request received(Revised)!";
				} else {
					subject = form.getPodNmae() + "-" + form.getBookingRef()  
					+ " - "+bookingPartyComName +" - "+repCompanyName+" Booking request received !";
				}
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(form.getEmail()));
				if(!"".equalsIgnoreCase(form.getAdditionalMailRecipeints())){
				System.out.println("Additional Mail Recipeints "+form.getAdditionalMailRecipeints());
				message.setCc(getMailId(form.getAdditionalMailRecipeints()));
				}
				message.setSubject(subject);
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("bookingSubmitData", form);
				model.put("bookingDate", cuuntDate + "");
				model.put("bookingParty", bookingPartyComName);
				model.put("repCompanyName", repCompanyName);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/BookingSubmitionMail.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

	public void bookingSubmitionMailToAll(EserviceNewWebBookingUim form,String repCompanyName,String bookingPartyComName) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				System.out.println("bookingSubmitionMailToAll() called.."+form.getBookingNo()+" "+form.getToPicMail());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String cuuntDate = formatter.format(date);
				String subject = "";
				String [] commodity=form.getCargoDescription().split("\r\n");
				for(int i=0;i<commodity.length;i++) {
					if(i==0)
						form.setShipper_Name_comm(commodity[i]);
					else if(i==1)
						form.setCommodity_Mail(commodity[i]);
					else if(i==2)
						form.setHs_Code(commodity[i]);
					else if(i==3)
						form.setCondition_Of_Container(commodity[i]);
				}
				if (form.getStatus().equals("Confirmed")) {
					subject = form.getPodNmae() + "-" + form.getBookingRef()  
							+ " - "+bookingPartyComName +" - "+repCompanyName+" Booking request received(Revised)!";
				} else {
					subject = form.getPodNmae() + "-" + form.getBookingRef()  
					+ " - "+bookingPartyComName +" - "+repCompanyName+" Booking request received !";
				}
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(form.getToPicMail()));
				if(!"".equalsIgnoreCase(form.getCcPicMail())){
					System.out.println("CcPicMail "+form.getCcPicMail());
					message.setCc(getMailId(form.getCcPicMail()));
					}
				if(!"".equalsIgnoreCase(form.getBccPicMail())){
					System.out.println("BccPicMail "+form.getBccPicMail());
					message.setBcc(getMailId(form.getBccPicMail()));
					}
				message.setSubject(subject);
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("bookingSubmitData", form);
				model.put("bookingDate", cuuntDate + "");
				model.put("bookingParty", bookingPartyComName);
				model.put("repCompanyName", repCompanyName);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/BookingSubmitionMail.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

	public void forgetPasswordMail(String userName, String password, String emailId, String UserId) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				String subject = "Your Password Request!";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(emailId));
				message.setSubject(subject);
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("userName", userName);
				model.put("password", password);
				model.put("userId", UserId);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/forgetPassword.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

	public void shippingSubmitionMail(EshippingInstructionUim form, byte[] content,String bookingPartyName,String RepCompanyName) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				System.out.println("shippingSubmitionMail() Started.."+form.getBookingNo()+" "+form.getEmail());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String cuuntDate = formatter.format(date);
				String subject = "SI Submitted! (" + form.getVesselNo() + "/" + form.getVoyageNo() +
						" - "+form.getPod()+" - "+form.getBookingNo()+") "
						+"("+ bookingPartyName + "/"+RepCompanyName+")";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(getMailId(form.getEmail()));
				if (form.getAdditionalEmail() != null && !form.getAdditionalEmail().equals("")) {
					System.out.println("Addtional mail "+form.getAdditionalEmail());
					message.setCc(getMailId(form.getAdditionalEmail()));
				}
				message.setSubject(subject);
				message.addAttachment(form.getBookingNo() + ".pdf", new ByteArrayResource(content));
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("shippingSubmitData", form);
				model.put("currenDate", cuuntDate + "");
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/esi-submission-external.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);

	}

	public void shippingSubmitionMailPicuser(EshippingInstructionUim form, byte[] content,String bookingPartyName,String RepCompanyName) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				System.out.println("shippingSubmitionMailPicuser() started.. "+form.getBookingNo()+" "+form.getToPicMail());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String cuuntDate = formatter.format(date);
				String subject = "SI Submitted! (" + form.getVesselNo() + "/" + form.getVoyageNo() +
						" - "+form.getPod()+" - "+form.getBookingNo()+") "
						+"("+ bookingPartyName + "/"+RepCompanyName+")";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(getMailId(form.getToPicMail()));
				if(!"".equalsIgnoreCase(form.getCcPicMail()) || form.getCcPicMail()!=null){
					System.out.println("CcPicMail : "+form.getCcPicMail());
					message.setCc(getMailId(form.getCcPicMail()));
					}
				if(!"".equalsIgnoreCase(form.getBccPicMail()) || form.getBccPicMail()!=null){
					System.out.println("BccPicMail() : "+form.getBccPicMail());
					message.setBcc(getMailId(form.getBccPicMail()));
					}
				message.setSubject(subject);
				message.addAttachment(form.getBookingNo() + ".pdf", new ByteArrayResource(content));
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("shippingSubmitData", form);
				model.put("currenDate", cuuntDate + "");
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/esi-submission-external-pic.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);

	}

	public void shippingSubmitionMailToAll(EshippingInstructionUim form, String to, byte[] content) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String cuuntDate = formatter.format(date);
				String subject = "SI Submitted! (" + form.getPol() + "-" + form.getBookingNo() + ") "
						+ form.getCustomerCompany() + " - " + form.getContact() + ")";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(to));
				message.setSubject(subject);
				message.addAttachment(form.getBookingNo() + ".pdf", new ByteArrayResource(content));
				message.setFrom(adminEmail); // could be parameterized...
				Map model = new HashMap();
				model.put("shippingSubmitData", form);
				model.put("currenDate", cuuntDate + "");
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/esi-submission-external.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);

	}

	public void bookingConfirmationMail(BookingConfirmationMail form) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				String subject = "Your booking request is now confirmed! ";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(form.getMailId()));
				message.setSubject(subject);
				message.setFrom(adminEmail);
				// could be parameterized...
				Map model = new HashMap();
				model.put("bookingConfirm", form);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/booking_confirmation_email_template.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}
	
	public void bookingCancelationMail(String bookingNo,String BookingRef,String date,String type,String mail,String additionalMail,String source) {
		System.out.println("bookingCancelationMail() mail "+mail);
		System.out.println("bookingCancelationMail() additionalMail "+additionalMail);
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				String subject ="";
				if(source.equals("SCREEN")) {
					if(!bookingNo.equals("") && bookingNo!=null)
						subject = "Booking cancel request received ! ["+bookingNo+"]";
					else
						subject = "Booking cancel request received ! ["+BookingRef+"]";
				}else {
					if(type.equals("BOOKINGCANCEL")) {
						if(!bookingNo.equals("") && bookingNo!=null)
							subject = "Your Booking request has been Cancelled! ["+bookingNo+"]";
						else
							subject = "Your Booking request has been Cancelled! ["+BookingRef+"]";
					}else if(type.equals("BOOKINGREJECTION")) {
						 subject = "Your Booking request has been Rejected!  ["+BookingRef+"]";
					}
				}
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(mail));
				if(additionalMail!=null && !additionalMail.equals("")) {
				message.setCc(getMailId(additionalMail));
				}
				message.setSubject(subject);
				message.setFrom(adminEmail);
				// could be parameterized...
				Map model = new HashMap();
				model.put("BOOKINGNO", bookingNo);
				model.put("BLNO", BookingRef );
				model.put("DATE", date+"" );
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/bookingCancelationMail.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}
	
	public void bookingCancelationPicMail(EserviceNewWebBookingUim form) {
		System.out.println("bookingCancelationPicMail() To mail "+form.getToPicMail());
		System.out.println("bookingCancelationPicMail() Cc Mail "+form.getCcPicMail());
		System.out.println("bookingCancelationPicMail() Bcc Mail "+form.getBccPicMail());
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String cuuntDate = formatter.format(date);
				
				String subject ="";
				subject = form.getPodNmae() + "-" + form.getBookingRef()  
				+" Booking cancel request received !";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(form.getToPicMail()));
				if(form.getCcPicMail()!=null && !form.getCcPicMail().equals("")) {
				message.setCc(getMailId(form.getCcPicMail()));
				}
				if(form.getBccPicMail()!=null && !form.getBccPicMail().equals("")) {
					message.setBcc(getMailId(form.getBccPicMail()));
				}
				message.setSubject(subject);
				message.setFrom(adminEmail);
				// could be parameterized...
				Map model = new HashMap();
				model.put("BOOKINGNO", form.getBookingNo());
				model.put("BLNO", form.getBookingRef() );
				model.put("DATE", cuuntDate+"" );
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/bookingCancelationMail.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

	public void siConfirmationMail(EsiSubmissionMail form) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String cuuntDate = formatter.format(date);
				String subject = "Your SI request is now confirmed! ";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(form.getMailId()));
				if(form.getAddMail()!=null && !form.getAddMail().equals("")) {
				message.setCc(getMailId(form.getAddMail()));
				}				
				message.setSubject(subject);
				message.setFrom(adminEmail);
				// could be parameterized...
				Map model = new HashMap();
				model.put("shippingSubmitData", form);
				model.put("currenDate", cuuntDate + "");
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/esi-confirmassion_email.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}
	
	public void siCancelationMail(String bookingNo,String BLno,String date,String mail,String additionalMail) {
		System.out.println("siCancelationMail() mail "+mail);
		System.out.println("siCancelationMail() additionalMail "+additionalMail);
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				String subject ="Your SI request has been Cancelled!  ["+bookingNo+"]";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(getMailId(mail)); 
				if(additionalMail!=null && !additionalMail.equals("")) {
				message.setCc(getMailId(additionalMail));
				}
				message.setSubject(subject);
				message.setFrom(adminEmail);
				// could be parameterized...
				Map model = new HashMap();
				model.put("BOOKINGNO", bookingNo);
				model.put("BLNO", BLno );
				model.put("DATE", date+"" );
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/eSiCancelationMail.vm", model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}
	

	public void sendRateInquireMail(GetRateUim form, byte[] bytes) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				String subject = "Your eRate  request is now confirmed! " + form.getQuotationNo();
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(getMailId(form.getEmaill()));
				message.setSubject(subject);
				message.setFrom(adminEmail);
				// could be parameterized...
				Map model = new HashMap();
				model.put("rateUIInput", form);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"com/rclgroup/dolphin/ezl/email/eRateConformation.vm", model);
				message.setText(text, true);
				message.addAttachment(form.getQuotationNo() + ".pdf", new ByteArrayResource(bytes));
			}
		};
		this.javaMailSender.send(preparator);
	}

	public String[] getMailId(String mail) {
		//String[] mailArr=mail.split(",");
		List list=new ArrayList();
		for(String ml:mail.split(",")) {
			if(ml.contains("@"))
				list.add(ml.trim());
			else
				continue;
		}
		String[] miArray = new String[list.size()];
		return (String[]) list.toArray(miArray);
	}
	
}
