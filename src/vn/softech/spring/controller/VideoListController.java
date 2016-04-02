package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.VideoDao;
import vn.softech.hibernate.TblVideo;
import vn.softech.form.VideoForm;

@Controller
@RequestMapping("/admin/videos")
public class VideoListController  {
	VideoDao videodao= new VideoDao();
	List<TblVideo> listvideo;
	TblVideo video = new TblVideo();
	private static Logger log = Logger.getLogger(VideoListController.class);	

	@RequestMapping(value = "/list")
	public String showListVideo (@ModelAttribute("video") VideoForm form, Model model) throws Exception {
		log.debug("showListVideo called.");	
		listvideo=videodao.get();
		log.debug(listvideo.size());		
		model.addAttribute("listvideo",listvideo);
		return "admin/videos/videolist";
	}
	
	@RequestMapping(value = "/action")
	public String actionVideo(@ModelAttribute("video") VideoForm form, Model model) throws Exception{
		log.info("actionVideo called.");
		String action = form.getAction();
		//debug
		log.debug("=============BBEGIN FORM==================");
		log.debug("Video Form videoID : " + form.getVideoId());
		log.debug("Video Form title   : " + form.getTitle());
		log.debug("Video Form Url     : " + form.getUrl());
		log.debug("Video Form Priorty : " + form.getPriority());
		log.debug("Video Form action  : " + form.getAction());
		log.debug("=============END FORM==================");
		Date now = new Date();
		
		if("".equals(action)){ //add new video
			log.info("called Add new.");
			video.setTitle(form.getTitle());
			video.setUrl(form.getUrl());
			video.setPriority(form.getPriority());
			video.setStatus((byte)1);
			video.setCreated(now);
			video.setModified(now);
			long videoId = videodao.save(video);
			log.info("videoId add New : " + videoId);
			if (videoId> 0) {
				log.debug("Add new video success");
			} else {
				log.debug("Add new video fail");
			}
			
		} else if("update".equals(action)){ // Update
			long videoId = form.getVideoId();
			log.info("called Update.");
			log.info("videoId update : " + videoId);
			if (videoId >= 0) {
				video = videodao.get(videoId);
				if(video != null){
					video.setVideoId(videoId);
					video.setTitle(form.getTitle());
					video.setUrl(form.getUrl());
					video.setPriority(form.getPriority());
					video.setModified(now);
					videodao.update(video);
				} else {
					log.info("Video này không tồn tại.");
				}
			} else {
				log.info("called update. videoId is null.");
			}
			
		} else if("delete".equals(action)){ // Delele
			log.info("called Dalete.");
			long videoId = form.getVideoId();
			if (videoId >= 0) {
				video = videodao.get(videoId);
				if(video != null){
					video.setStatus((byte)3);
					video.setModified(now);
					videodao.update(video);
				} else {
					log.info("Video này không tồn tại.");
				}
			} else {
				log.debug("Delete video fail");
			}
		}
		
		//load video list
		listvideo=videodao.get();
		log.debug(listvideo.size());		
		model.addAttribute("listvideo",listvideo);
		return "admin/videos/videolist";
	}
	
	@RequestMapping(value = "/deleteAjax")
	public String deleteVideo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrVideoId = request.getParameter("videoId");
		if ((arrVideoId == null) || ("".equals(arrVideoId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"videoId là rỗng\"");
			response.getWriter().write("}");
			return null;
		}
		
		log.debug("arrVideoId: " + arrVideoId);

		String error = videodao.updateBatch(arrVideoId);
		if ((error == null) || ("".equals(error))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"\"");
			response.getWriter().write("}");
			return null;
		}
		response.getWriter().write("{");
		response.getWriter().write("\"error\":\"" + error + "\"");
		response.getWriter().write("}");
		return null;
	}
}
