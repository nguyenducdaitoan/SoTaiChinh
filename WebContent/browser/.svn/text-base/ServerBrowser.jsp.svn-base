<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ include file="/browser/InitBrowser.jsp" %>
<%
		if(request.getParameter("FileType") != null)
			request.setAttribute("FileType", request.getParameter("FileType"));
		if(	request.getParameter("EltID") != null)
			request.setAttribute("EltID", request.getParameter("EltID"));
		if(	request.getParameter("dir") != null)
			request.setAttribute("dir", request.getParameter("dir"));
		//Get the current browsing directory
		// The browser_name variable is used to keep track of the URI
		// of the jsp file itself.  It is used in all link-backs.
//		final String browser_name = request.getRequestURI();
		final String browser_name = "/browser/ServerBrowser.jsp";	//lehvuk22@gmail.com
		String typeFile = (String)request.getAttribute("FileType");
		String eltID = (String)request.getAttribute("EltID");
		
		//System.out.println(typeFile +"..1.."+ eltID);
		String rootPath = application.getRealPath(""+ application.getInitParameter("BaseDirForBrowser"));
		
		int idxFileType=0;
		if(typeFile!= null){
			for( ; idxFileType < FileTypes.length; idxFileType++)
				if(FileTypes[idxFileType].equalsIgnoreCase(typeFile))
					break;
			if(idxFileType == FileTypes.length) typeFile = "File";
			rootPath += "\\"+ typeFile;
		}
		START_FOLDER = rootPath;
		//System.out.println("START "+ START_FOLDER);
		File rf = new File(START_FOLDER);
		if( rf != null && !rf.exists()) rf.mkdirs();
				
		final String FOL_IMG = "";
		boolean nohtml = false;
		boolean dir_view = true;
		
		// View file
		if (request.getParameter("file") != null) {
            File f = new File(request.getParameter("file"));
            if (!isAllowed(f, false)) {
                request.setAttribute("dir", f.getParent());
                request.setAttribute("error", "You are not allowed to access "+f.getAbsolutePath());
            }
            else if (f.exists() && f.canRead()) {
                if (isPacked(f.getName(), false)) {
                    //If zipFile, do nothing here
                }
                else{
                    String mimeType = getMimeType(f.getName());
                    response.setContentType(mimeType);
                    if (mimeType.equals("text/plain")) response.setHeader(
                            "Content-Disposition", "inline;filename=\"temp.txt\"");
                    else response.setHeader("Content-Disposition", "inline;filename=\""
                            + f.getName() + "\"");
                    BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
                    byte buffer[] = new byte[8 * 1024];
                    out.clearBuffer();
                    OutputStream out_s = new Writer2Stream(out);
                    copyStreamsWithoutClose(fileInput, out_s, buffer);
                    fileInput.close();
                    out_s.flush();
                    nohtml = true;
                    dir_view = false;
                }
            }
            else {
                request.setAttribute("dir", f.getParent());
                request.setAttribute("error", "File " + f.getAbsolutePath()
                        + " does not exist or is not readable on the server");
            }
		}
		// Download selected files as zip file
		else if ((request.getParameter("Submit") != null)
				&& (request.getParameter("Submit").equals(SAVE_AS_ZIP))) {
		}
		// Download file
		else if (request.getParameter("downfile") != null) {
		}
		if (nohtml) return;
		//else
			// If no parameter is submitted, it will take the path from jsp file browser
			if (request.getAttribute("dir") == null) {
				String path = null;
				File f = new File(rootPath);
				
				//This is a hack needed for tomcat
				while (f != null && !f.exists())
					f = f.getParentFile();
				if (f != null)
					path = f.getAbsolutePath();
				
				if (path == null) { // handle the case where we are not in a directory (ex: war file)
					path = new File(".").getAbsolutePath();
				}
				
				//Check path
                if (!isAllowed(new File(path), false)){
                	//TODO Blacklist
                    if (RESTRICT_PATH.indexOf(";")<0) path = RESTRICT_PATH;
                    else path = RESTRICT_PATH.substring(0, RESTRICT_PATH.indexOf(";"));
                }
				request.setAttribute("dir", path);
			}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
<meta name="robots" content="noindex">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<%
			//If a cssfile exists, it will take it
			String cssPath = null;
			if (application.getRealPath(request.getRequestURI()) != null) cssPath = new File(
					application.getRealPath(request.getRequestURI())).getParent()
					+ File.separator + CSS_NAME;
			if (cssPath == null) cssPath = application.getResource(CSS_NAME).toString();
			if (new File(cssPath).exists()) {
%>
<link rel="stylesheet" type="text/css" href="<%=CSS_NAME%>">
      <%	}
			else if (request.getParameter("uplMonitor") == null) {%>
	<style type="text/css">
		input.button {background-color: #CCCCCC; color: #000000; border: 1px solid #999999; margin: 5px 1px 5px 1px;}
		input.textfield {margin: 5px 1px 5px 1px;}
		input.button:Hover { color: #444444 }
		input.checkbox { margin: 0; padding: 0;}
		table.filelist {background-color: #CCCCCC; width:100%; border:0px none #ffffff}
		.formular {margin: 1px; background-color:#ffffff; padding: 1em; border:1px solid #000000;}
		.formular2 {margin: 1px;}
		th { background-color:#c0c0c0 }
		tr.mouseout { background-color:#ffffff; }
		tr.mousein  { background-color:#eeeeee; }
		tr.checked  { background-color:#eeeeee }
		tr.mousechecked { background-color:#c0c0c0 }
		td { font-family:Verdana, Arial, Helvetica, sans-serif; font-size: 8pt; color: #666666;}
		td.message { background-color: #FFFF00; color: #000000; text-align:center; font-weight:bold}
		td.error { background-color: #FF0000; color: #000000; text-align:center; font-weight:bold}
		.message { background-color: #FFFF00; color: #000000; text-align:center; font-weight:bold}
		.error { background-color: #FF0000; color: #000000; text-align:center; font-weight:bold}
		A { text-decoration: none; }
		A:Hover { color : Red; text-decoration : underline; }
		BODY { 
			font-family:Verdana, Arial, Helvetica, sans-serif; 
			font-size: 8pt; 
			color: #666666;
			scrollbar-face-color: #ffffff;
			scrollbar-shadow-color: #006699;
			scrollbar-base-color : #ffffff;
			scrollbar-highlight-color: #006699;
			scrollbar-3dlight-color: #ffffff;
			scrollbar-darkshadow-color: #ffffff;
			scrollbar-track-color: #f8f8f8;
			scrollbar-arrow-color: #006699;
		}
		.toppane-body {
			OVERFLOW-Y: scroll; 
			OVERFLOW-X: scroll;
			PADDING-RIGHT: 0px; 
			PADDING-LEFT: 0px; 
			PADDING-BOTTOM: 0px; 
			PADDING-TOP: 0px; 
			HEIGHT: 100%;
			width:100%;
		}
	</style>
	<%}
		
        //Check path
        if (!isAllowed(new File((String)request.getAttribute("dir")), false)){
            request.setAttribute("error", "You are not allowed to access " + request.getAttribute("dir"));
        }
		//Upload monitor
		else if (request.getParameter("uplMonitor") != null) {%>
	<style type="text/css">
		BODY { font-family:Verdana, Arial, Helvetica, sans-serif; font-size: 8pt; color: #666666;}
	</style><%
			String fname = request.getParameter("uplMonitor");
			//First opening
			boolean first = false;
			if (request.getParameter("first") != null) first = true;
			UplInfo info = new UplInfo();
			if (!first) {
				info = UploadMonitor.getInfo(fname);
				if (info == null) {
					//Windows
					int posi = fname.lastIndexOf("\\");
					if (posi != -1) info = UploadMonitor.getInfo(fname.substring(posi + 1));
				}
				if (info == null) {
					//Unix
					int posi = fname.lastIndexOf("/");
					if (posi != -1) info = UploadMonitor.getInfo(fname.substring(posi + 1));
				}
			}
			dir_view = false;
			request.setAttribute("dir", null);
			if (info.aborted) {
				UploadMonitor.remove(fname);
				%>
</head>
<body>
<b>Upload of <%=fname%></b><br><br>
Upload aborted.</body>
</html><%
			}
			else if (info.totalSize != info.currSize || info.currSize == 0) {
				%>
<META HTTP-EQUIV="Refresh" CONTENT="<%=UPLOAD_MONITOR_REFRESH%>;URL=<%=browser_name %>?uplMonitor=<%=URLEncoder.encode(fname)%>">
</head>
<body>
<b>Upload of <%=fname%></b><br><br>
<center>
<table height="20px" width="90%" bgcolor="#eeeeee" style="border:1px solid #cccccc"><tr>
<td bgcolor="blue" width="<%=info.getPercent()%>%"></td><td width="<%=100-info.getPercent()%>%"></td>
</tr></table></center>
<%=convertFileSize(info.currSize)%> from <%=convertFileSize(info.totalSize)%>
(<%=info.getPercent()%> %) uploaded (Speed: <%=info.getUprate()%>).<br>
Time: <%=info.getTimeElapsed()%> from <%=info.getTimeEstimated()%>
</body>
</html><%
			}
			else {
				UploadMonitor.remove(fname);
				%>
</head>
<body onload="javascript:window.close()">
<b>Upload of <%=fname%></b><br><br>
Upload finished.
</body>
</html><%
			}
		}
		
		//Comandwindow
		else if (request.getParameter("command") != null) {
		//not use
		}

		//Click on a filename, special viewer (zip+jar file)
		else if (request.getParameter("file") != null) {
			File f = new File(request.getParameter("file"));
            if (!isAllowed(f, false)){
                request.setAttribute("error", "You are not allowed to access " + f.getAbsolutePath());
            }
			else if (isPacked(f.getName(), false)) {
				//ZipFile
				try {
					ZipFile zf = new ZipFile(f);
					Enumeration entries = zf.entries();
%>
<title><%= f.getAbsolutePath()%></title>
</head>
<body>
	<h2>Content of <%=conv2Html(f.getName())%></h2><br />
	<table class="filelist" cellspacing="1px" cellpadding="0px">
	<th>Name</th><th>Uncompressed size</th><th>Compressed size</th><th>Compr. ratio</th><th>Date</th>
<%
					long size = 0;
					int fileCount = 0;
					while (entries.hasMoreElements()) {
						ZipEntry entry = (ZipEntry) entries.nextElement();
						if (!entry.isDirectory()) {
							fileCount++;
							size += entry.getSize();
							long ratio = 0;
							if (entry.getSize() != 0) ratio = (entry.getCompressedSize() * 100)
									/ entry.getSize();
							out.println("<tr class=\"mouseout\"><td>" + conv2Html(entry.getName())
									+ "</td><td>" + convertFileSize(entry.getSize()) + "</td><td>"
									+ convertFileSize(entry.getCompressedSize()) + "</td><td>"
									+ ratio + "%" + "</td><td>"
									+ dateFormat.format(new Date(entry.getTime())) + "</td></tr>");

						}
					}
					zf.close();
					//No directory view
					dir_view = false;
					request.setAttribute("dir", null);
%>
	</table>
	<p align=center>
	<b><%=convertFileSize(size)%> in <%=fileCount%> files in <%=f.getName()%>. Compression ratio: <%=(f.length() * 100) / size%>%
	</b></p>
</body>
</html>
<%
				}
				catch (ZipException ex) {
					request.setAttribute("error", "Cannot read " + f.getName()
							+ ", no valid zip file");
				}
				catch (IOException ex) {
					request.setAttribute("error", "Reading of " + f.getName() + " aborted. Error: "
							+ ex);
				}
			}
		}
		// Upload
		else if ((request.getContentType() != null)
				&& (request.getContentType().toLowerCase().startsWith("multipart"))) {
			
			if (!ALLOW_UPLOAD){
                request.setAttribute("error", "Upload is forbidden!");
            }
			response.setContentType("text/html");
			HttpMultiPartParser parser = new HttpMultiPartParser();
			boolean error = false;
			try {
				int bstart = request.getContentType().lastIndexOf("oundary=");
				String bound = request.getContentType().substring(bstart + 8);
				int clength = request.getContentLength();
				Hashtable ht = parser.processData(request.getInputStream(), bound, tempdir, clength);
				
				if (!isAllowed(new File((String)ht.get("dir")), false)){
                    //This is a hack, cos we are writing to this directory
                	request.setAttribute("error", "You are not allowed to access " + ht.get("dir"));
                    error = true;
                }
				else if (ht.get("myFile") != null) {
					FileInfo fi = (FileInfo) ht.get("myFile");
					File f = fi.file;
					
					String deniedExts = application.getInitParameter("UploadDeniedExtensionsFile");
					//filter extensions
					String ext = getExtension(fi.clientFileName);
					
					if(deniedExts != null && !deniedExts.equals("")){
						StringTokenizer st = new StringTokenizer(deniedExts, "|");
						String s = "";
						for(;st.hasMoreTokens(); ){
							s = st.nextToken();
							
							if(ext.equalsIgnoreCase(s)){
			                    error = true;
			                    break;
							}
						}
					
					}
					
					UplInfo info = UploadMonitor.getInfo(fi.clientFileName);
					if(error){
						request.setAttribute("error", "File extension is denied");
		                f.delete();
					}else if (info != null && info.aborted) {
						f.delete();
						request.setAttribute("error", "Upload aborted");
					}
					else {
						// Move file from temp to the right dir
						String path = (String) ht.get("dir");
						if (!path.endsWith(File.separator)) path = path + File.separator;
						if (!f.renameTo(new File(path + f.getName()))) {
							request.setAttribute("error", "Cannot upload file.");
							error = true;
							f.delete();
						}
					}
				}
				else {
					request.setAttribute("error", "No file selected for upload");
					error = true;
				}
				
				request.setAttribute("dir", (String) ht.get("dir"));
				request.setAttribute("FileType", (String)ht.get("FileType"));
				request.setAttribute("EltID", (String)ht.get("EltID"));

			}
			catch (Exception e) {
				request.setAttribute("error", "Error " + e + ". Upload aborted");
				error = true;
			}
			if (!error) request.setAttribute("message", "File upload correctly finished.");
		}
		// The form to edit a text file
		else if (request.getParameter("editfile") != null) {
		//not use
		}
		// Save or cancel the edited file
		else if (request.getParameter("nfile") != null) {
		//not use
		}
		//Unpack file to the current directory without overwriting
		else if (request.getParameter("unpackfile") != null) {
			File f = new File(request.getParameter("unpackfile"));
			String root = f.getParent();
			request.setAttribute("dir", root);
            if (!isAllowed(new File(root), true)){
                request.setAttribute("error", "You are not allowed to access " + root);
            }
			//Check if file exists
			else if (!f.exists()) {
				request.setAttribute("error", "Cannot unpack " + f.getName()
						+ ", file does not exist");
			}
			//Check if directory is readonly
			else if (!f.getParentFile().canWrite()) {
				request.setAttribute("error", "Cannot unpack " + f.getName()
						+ ", directory is write protected.");
			}
			//GZip
			else if (f.getName().toLowerCase().endsWith(".gz")) {
				//New name is old Name without .gz
				String newName = f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 3);
				try {
					byte buffer[] = new byte[0xffff];
					copyStreams(new GZIPInputStream(new FileInputStream(f)), new FileOutputStream(
							newName), buffer);
				}
				catch (IOException ex) {
					request.setAttribute("error", "Unpacking of " + f.getName()
							+ " aborted. Error: " + ex);
				}
			}
			//Else try Zip
			else {
				try {
					ZipFile zf = new ZipFile(f);
					Enumeration entries = zf.entries();
					//First check whether a file already exist
					boolean error = false;
					while (entries.hasMoreElements()) {
						ZipEntry entry = (ZipEntry) entries.nextElement();
						if (!entry.isDirectory()
								&& new File(root + File.separator + entry.getName()).exists()) {
							request.setAttribute("error", "Cannot unpack " + f.getName()
									+ ", File " + entry.getName() + " already exists.");
							error = true;
							break;
						}
					}
					if (!error) {
						//Unpack File
						entries = zf.entries();
						byte buffer[] = new byte[0xffff];
						while (entries.hasMoreElements()) {
							ZipEntry entry = (ZipEntry) entries.nextElement();
							File n = new File(root + File.separator + entry.getName());
							if (entry.isDirectory()) n.mkdirs();
							else {
								n.getParentFile().mkdirs();
								n.createNewFile();
								copyStreams(zf.getInputStream(entry), new FileOutputStream(n),
										buffer);
							}
						}
						zf.close();
						request.setAttribute("message", "Unpack of " + f.getName()
								+ " was successful.");
					}
				}
				catch (ZipException ex) {
					request.setAttribute("error", "Cannot unpack " + f.getName()
							+ ", no valid zip file");
				}
				catch (IOException ex) {
					request.setAttribute("error", "Unpacking of " + f.getName()
							+ " aborted. Error: " + ex);
				}
			}
		}
		// Delete Files
		else if ((request.getParameter("Submit") != null)
				&& (request.getParameter("Submit").equals(DELETE_FILES))) {
			Vector v = expandFileList(request.getParameterValues("selfile"), true);
			boolean error = false;
			//delete backwards
			for (int i = v.size() - 1; i >= 0; i--) {
				File f = (File) v.get(i);
                if (!isAllowed(f, true)){
                    request.setAttribute("error", "You are not allowed to access " + f.getAbsolutePath());
                    error = true;
                    break;
                }
				if (!f.canWrite() || !f.delete()) {
					request.setAttribute("error", "Cannot delete " + f.getAbsolutePath()
							+ ". Deletion aborted");
					error = true;
					break;
				}
			}
			if ((!error) && (v.size() > 1)) request.setAttribute("message", "All files deleted");
			else if ((!error) && (v.size() > 0)) request.setAttribute("message", "File deleted");
			else if (!error) request.setAttribute("error", "No files selected");
		}
		// Create Directory
		else if ((request.getParameter("Submit") != null)
				&& (request.getParameter("Submit").equals(CREATE_DIR))) {
			String dir = "" + request.getAttribute("dir");
			String dir_name = request.getParameter("cr_dir");
			String new_dir = getDir(dir, dir_name);
            if (!isAllowed(new File(new_dir), true)){
                request.setAttribute("error", "You are not allowed to access " + new_dir);
            }
			else if (new File(new_dir).mkdirs()) {
				request.setAttribute("message", "Directory created");
			}
			else request.setAttribute("error", "Creation of directory " + new_dir + " failed");
		}
		// Create a new empty file
		else if ((request.getParameter("Submit") != null)
				&& (request.getParameter("Submit").equals(CREATE_FILE))) {
			//not use		
		}
		// Rename a file
		else if ((request.getParameter("Submit") != null)
				&& (request.getParameter("Submit").equals(RENAME_FILE))) {
				//not use
		}
		// Move selected file(s)
		else if ((request.getParameter("Submit") != null)
				&& (request.getParameter("Submit").equals(MOVE_FILES))) {
			Vector v = expandFileList(request.getParameterValues("selfile"), true);
			String dir = "" + request.getAttribute("dir");
			String dir_name = request.getParameter("cr_dir");
			String new_dir = getDir(dir, dir_name);
            if (!isAllowed(new File(new_dir), false)){
                request.setAttribute("error", "You are not allowed to access " + new_dir);
            }
            else{
    			boolean error = false;
                // This ensures that new_dir is a directory
                if (!new_dir.endsWith(File.separator)) new_dir += File.separator;
                for (int i = v.size() - 1; i >= 0; i--) {
                    File f = (File) v.get(i);
                    if (!isAllowed(f, true)){
                        request.setAttribute("error", "You are not allowed to access " + f.getAbsolutePath());
                        error = true;
                        break;
                    }
                    else if (!f.canWrite() || !f.renameTo(new File(new_dir
                            + f.getAbsolutePath().substring(dir.length())))) {
                        request.setAttribute("error", "Cannot move " + f.getAbsolutePath()
                                + ". Move aborted");
                        error = true;
                        break;
                    }
                }
                if ((!error) && (v.size() > 1)) request.setAttribute("message", "All files moved");
                else if ((!error) && (v.size() > 0)) request.setAttribute("message", "File moved");
                else if (!error) request.setAttribute("error", "No files selected");
            }
		}
		// Copy Files
		else if ((request.getParameter("Submit") != null)
				&& (request.getParameter("Submit").equals(COPY_FILES))) {
			Vector v = expandFileList(request.getParameterValues("selfile"), true);
			String dir = (String) request.getAttribute("dir");
			if (!dir.endsWith(File.separator)) dir += File.separator;
			String dir_name = request.getParameter("cr_dir");
			String new_dir = getDir(dir, dir_name);
            if (!isAllowed(new File(new_dir), true)){
                request.setAttribute("error", "You are not allowed to access " + new_dir);
            }
            else{
    			boolean error = false;
                if (!new_dir.endsWith(File.separator)) new_dir += File.separator;
                try {
                    byte buffer[] = new byte[0xffff];
                    for (int i = 0; i < v.size(); i++) {
                        File f_old = (File) v.get(i);
                        File f_new = new File(new_dir + f_old.getAbsolutePath().substring(dir.length()));
                        if (!isAllowed(f_old, false)|| !isAllowed(f_new, true)){
                            request.setAttribute("error", "You are not allowed to access " + f_new.getAbsolutePath());
                            error = true;
                        }
                        else if (f_old.isDirectory()) f_new.mkdirs();
                        // Overwriting is forbidden
                        else if (!f_new.exists()) {
                            copyStreams(new FileInputStream(f_old), new FileOutputStream(f_new), buffer);
                        }
                        else {
                            // File exists
                            request.setAttribute("error", "Cannot copy " + f_old.getAbsolutePath()
                                    + ", file already exists. Copying aborted");
                            error = true;
                            break;
                        }
                    }
                }
                catch (IOException e) {
                    request.setAttribute("error", "Error " + e + ". Copying aborted");
                    error = true;
                }
                if ((!error) && (v.size() > 1)) request.setAttribute("message", "All files copied");
                else if ((!error) && (v.size() > 0)) request.setAttribute("message", "File copied");
                else if (!error) request.setAttribute("error", "No files selected");
            }
		}
		// Directory viewer
		if (dir_view && request.getAttribute("dir") != null) {
			File f = new File("" + request.getAttribute("dir"));
			if(typeFile == null)
				typeFile = (String)request.getAttribute("FileType");
			if(eltID == null)
				eltID = (String)request.getAttribute("EltID");
	
			//System.out.println(typeFile +"..2.."+ eltID);
			idxFileType=0;
			for( ; idxFileType < FileTypes.length; idxFileType++)
				if(FileTypes[idxFileType].equalsIgnoreCase(typeFile))
					break;
			if(idxFileType == FileTypes.length) typeFile = "File";
			rootPath = application.getRealPath(""+ application.getInitParameter("BaseDirForBrowser")) + "\\"+typeFile;
			START_FOLDER = rootPath;
			rf = new File(START_FOLDER);
			if( rf != null && !rf.exists()) rf.mkdirs();
									
			//Check, whether the dir exists
			if (!f.exists() || !isAllowed(f, false)) {
				if (!f.exists()){
                    request.setAttribute("error", "Directory " + f.getAbsolutePath() + " does not exist.");
                }
                else{
                    request.setAttribute("error", "You are not allowed to access " + f.getAbsolutePath());
                }
				//if attribute olddir exists, it will change to olddir
				if (request.getAttribute("olddir") != null && isAllowed(new File((String) request.getAttribute("olddir")), false)) {
					f = new File("" + request.getAttribute("olddir"));
				}
				//try to go to the parent dir
				else {
					if (f.getParent() != null && isAllowed(f, false)) f = new File(f.getParent());
				}
				//If this dir also do also not exist, go back to browser.jsp root path
				if (!f.exists()) {
					String path = null;
					if (application.getRealPath(""+ application.getInitParameter("BaseDirForBrowser")) != null) 
					path = new File(""+ application.getInitParameter("BaseDirForBrowser")).getParent();

					if (path == null) // handle the case were we are not in a directory (ex: war file)
					path = new File(".").getAbsolutePath();
					f = new File(path);
				}
				if (isAllowed(f, false)) request.setAttribute("dir", f.getAbsolutePath());
                else request.setAttribute("dir", null);
			}
%>

<script type="text/javascript">
	<%// This section contains the Javascript used for interface elements %>
			var check = false;
			<%// Disables the checkbox feature %>
			function dis(){check = true;}

			var DOM = 0, MS = 0, OP = 0, b = 0;
			<%// Determine the browser type %>
			function CheckBrowser(){
				if (b == 0){
					if (window.opera) OP = 1;
					// Moz or Netscape
					if(document.getElementById) DOM = 1;
					// Micro$oft
					if(document.all && !OP) MS = 1;
					b = 1;
				}
			}
			<%// Allows the whole row to be selected %>
			function selrow (element, i){
				var erst;
				CheckBrowser();
				if ((OP==1)||(MS==1)) erst = element.firstChild.firstChild;
				else if (DOM==1) erst = element.firstChild.nextSibling.firstChild;
				<%// MouseIn %>
				if (i==0){
					if (erst.checked == true) element.className='mousechecked';
					else element.className='mousein';
				}
				<%// MouseOut %>
				else if (i==1){
					if (erst.checked == true) element.className='checked';
					else element.className='mouseout';
				}
				<%    // MouseClick %>
				else if ((i==2)&&(!check)){
					if (erst.checked==true) element.className='mousein';
					else element.className='mousechecked';
					erst.click();
				}
				else check=false;
			}
			<%// Filter files and dirs in FileList%>
			function filter (begriff){
				var suche = begriff.value.toLowerCase();
				var table = document.getElementById("filetable");
				var ele;
				for (var r = 1; r < table.rows.length; r++){
					ele = table.rows[r].cells[1].innerHTML.replace(/<[^>]+>/g,"");
					if (ele.toLowerCase().indexOf(suche)>=0 )
						table.rows[r].style.display = '';
					else table.rows[r].style.display = 'none';
		      	}
			}
			<%//(De)select all checkboxes%>	
			function AllFiles(){
				for(var x=0;x < document.FileList.elements.length;x++){
					var y = document.FileList.elements[x];
					var ytr = y.parentNode.parentNode;
					var check = document.FileList.selall.checked;
					if(y.name == 'selfile' && ytr.style.display != 'none'){
						if (y.disabled != true){
							y.checked = check;
							if (y.checked == true) ytr.className = 'checked';
							else ytr.className = 'mouseout';
						}
					}
				}
			}
			
			function shortKeyHandler(_event){
				if (!_event) _event = window.event;
				if (_event.which) {
					keycode = _event.which;
				} else if (_event.keyCode) {
					keycode = _event.keyCode;
				}
				var t = document.getElementById("text_Dir");
				//z
				/*
				if (keycode == 122){
					document.getElementById("but_Zip").click();
				}
				*/
				//r, F2
				/*
				else if (keycode == 113 || keycode == 114){
					var path = prompt("Please enter new filename", "");
					if (path == null) return;
					t.value = path;
					document.getElementById("but_Ren").click();
				}
				*/
				//c
				/*
				else if (keycode == 99){
					var path = prompt("Please enter filename", "");
					if (path == null) return;
					t.value = path;
					document.getElementById("but_NFi").click();
				}
				*/
				//d
				//else 
				if (keycode == 100){
					var path = prompt("Please enter directory name", "");
					if (path == null) return;
					t.value = path;
					document.getElementById("but_NDi").click();
				}
				//m
				else if (keycode == 109){
					var path = prompt("Please enter move destination", "");
					if (path == null) return;
					t.value = path;
					document.getElementById("but_Mov").click();
				}
				//y
				else if (keycode == 121){
					var path = prompt("Please enter copy destination", "");
					if (path == null) return;
					t.value = path;
					document.getElementById("but_Cop").click();
				}
				//l
				/*
				else if (keycode == 108){
					document.getElementById("but_Lau").click();
				}
				*/
				//Del
				else if (keycode == 46){
					document.getElementById("but_Del").click();
				}
			}

			function popUp(URL){
				fname = document.getElementsByName("myFile")[0].value;
				if (fname != ""){
					window.open(URL+"?first&uplMonitor="+encodeURIComponent(fname),"","width=400,height=150,resizable=yes,depend=yes");
				}
			}
			
			document.onkeypress = shortKeyHandler;
			
			
			function returnFilePath(idParentElement, valueReturn){
				var e = opener.document.getElementById(idParentElement);
				if(e != null){
					opener.document.getElementById(idParentElement).value = valueReturn;
				}else{
					alert('Không tìm thấy phần tử với ID = '+idParentElement);
				}
				window.close();
			}
</script>
<title><%=request.getAttribute("dir")%></title>
</head>
<body>
<%
			//Output message
			if (request.getAttribute("message") != null) {
				out.println("<p class=\"message\">");
				out.println(request.getAttribute("message"));
				out.println("</p>");
			}
			//Output error
			if (request.getAttribute("error") != null) {
				out.println("<p class=\"error\">");
				out.println(request.getAttribute("error"));
				out.println("</p>");
			}
            if (request.getAttribute("dir") != null){
%>

	<form class="formular" action="/browser/ServerBrowser.do" method="Post" name="FileList">
		<input type="hidden" name="FileType" value="<%= request.getAttribute("FileType") %>" />
		<input type="hidden" name="EltID" value="<%= request.getAttribute("EltID") %>" />
    Filename filter: <input name="filt" onKeypress="event.cancelBubble=true;" onkeyup="filter(this)" type="text">
    <br /><br />
	<table cellspacing="0px" cellpadding="0px" width="100%" border=0>
<%
			// Output the table, starting with the headers.
			String dir = URLEncoder.encode("" + request.getAttribute("dir"), "ISO-8859-1");
			String cmd = browser_name + "?dir=" + dir+ "&FileType="+typeFile+"&EltID="+eltID;
			int sortMode = 1;
			if (request.getParameter("sort") != null) 
				sortMode = Integer.parseInt(request.getParameter("sort"));
			int[] sort = new int[] {1, 2, 3, 4};
			for (int i = 0; i < sort.length; i++)
				if (sort[i] == sortMode) sort[i] = -sort[i];
%>
					<tr>
						<th width="20px"><input type="checkbox" class="checkbox" name="selall" onClick="AllFiles(this.form)" title="Select all"></th>
						<th title="Sort files by name" align=center width="260px">
							<a href="<%=cmd +"&amp;sort="+sort[0]%>"><font size="2px">Name</font></a>
						</th>
						<th title="Sort files by size" align="center" width="70px">
							<a href="<%= cmd + "&amp;sort=" + sort[1]%>"><font size="2px">Size</font></a>
						</th>
						<th title="Sort files by type" align="center" width="40px">
							<a href="<%= cmd+ "&amp;sort=" + sort[3]%>"><font size="2px">Type</font></a>
						</th>
						<th title="Sort files by date" align="center" width="155px">
							<a href="<%= cmd + "&amp;sort=" + sort[2]%>"><font size="2px">Date</font></a>
						</th>
	<%
			if (!READ_ONLY) out.print ("<th width=\"45px\">&nbsp;</th>");
			out.println("</tr>");
			
			char trenner = File.separatorChar;
			// Output the Root-Dirs, without FORBIDDEN_DRIVES
			File[] entry = null;
	%>
			<tr>
			<td colspan="6" height="250px" width=100%>
			<div class="toppane-body">
			<table id="filetable" class="filelist" cellspacing="1px" cellpadding="0px">
	<%			
			// Output the parent directory link ".."
			if ( isUpParent(f.getParentFile()) && f.getParent() != null) {
	%>		
				<tr class="mouseout" onmouseover="this.className='mousein'" onmouseout="this.className='mouseout'">
					<td width="10px"></td>
					<td align=left width="280px">
						<a href="<%=browser_name + "?sort=" + sortMode + "&amp;dir="+ URLEncoder.encode(f.getParent()) + "&FileType="+typeFile+"&EltID="+eltID %>">
							<%=FOL_IMG + "[..]"%>
						</a>
					</td>
					<td width="70px">&nbsp;</td>
					<td width="40px">&nbsp;</td>
					<td width="155px">&nbsp;</td>
	<%
				if (!READ_ONLY) out.print ("<td width=\"40px\">&nbsp;</td>");	
	%>
				</tr>
	<%			
			}
			// Output all files and dirs and calculate the number of files and total size
			entry = f.listFiles();
			if (entry == null) entry = new File[] {};
			long totalSize = 0; // The total size of the files in the current directory
			long fileCount = 0; // The count of files in the current working directory
			
			if (entry != null && entry.length > 0) {
				Arrays.sort(entry, new FileComp(sortMode));
				for (int i = 0; i < entry.length; i++) {
					String name = URLEncoder.encode(entry[i].getAbsolutePath());
					String type = "File"; // This String will tell the extension of the file
					if (entry[i].isDirectory()) type = "DIR"; // It's a DIR
					else {
						String tempName = entry[i].getName().replace(' ', '_');
						if (tempName.lastIndexOf('.') != -1) 
							type = tempName.substring(tempName.lastIndexOf('.')).toLowerCase();
					}
					
					String ahref = "<a onmousedown=\"dis()\" href=\"" + browser_name + "?sort="
							+ sortMode + "&FileType="+typeFile+"&EltID="+eltID + "&amp;";
					//String dlink = "&nbsp;"; // The "Download" link
					String elink = "&nbsp;"; // The "Edit" link
					String buf = conv2Html(entry[i].getName());
					if (!entry[i].canWrite()) buf = "<i>" + buf + "</i>";
					String link = buf; // The standard view link, uses Mime-type
					if (entry[i].isDirectory()) {
						if (entry[i].canRead() && USE_DIR_PREVIEW) {
							//Show the first DIR_PREVIEW_NUMBER directory entries in a tooltip
							File[] fs = entry[i].listFiles();
							if (fs == null) fs = new File[] {};
							Arrays.sort(fs, new FileComp());
							StringBuffer filenames = new StringBuffer();
							for (int i2 = 0; (i2 < fs.length) && (i2 < 10); i2++) {
								String fname = conv2Html(fs[i2].getName());
								if (fs[i2].isDirectory()) 
									filenames.append("[" + fname + "];");
								else filenames.append(fname + ";");
							}
							
							if (fs.length > DIR_PREVIEW_NUMBER) filenames.append("...");
							else if (filenames.length() > 0) 
								filenames.setLength(filenames.length() - 1);
								
							link = ahref + "dir=" + name + "\" title=\"" + filenames + "\">"
									+ FOL_IMG + "[" + buf + "]</a>";
						}
						
						else if (entry[i].canRead()) {
							link = ahref + "dir=" + name + "\">" + FOL_IMG + "[" + buf + "]</a>";
						}
						else link = FOL_IMG + "[" + buf + "]";
					}
					else if (entry[i].isFile()) { //Entry is file
						//String selFile = "<a href=\"returnFilePath('myFileName','"+ name +"');\" >"+ buf + "</a>";
						totalSize = totalSize + entry[i].length();
						fileCount = fileCount + 1;
						if (entry[i].canRead()) {
							//dlink = ahref + "downfile=" + name + "\">Download</a>";
							//If you click at the filename
							if (USE_POPUP)
								link = ahref + "file=" + name + "\" target=\"_blank\">"	+ buf + "</a>";
							else link = ahref + "file=" + name + "\">" + buf + "</a>";
							
							if (entry[i].canWrite()) { // The file can be edited
								//If it is a zip or jar File you can unpack it
								//if (isPacked(name, true)) 
								//	elink = ahref + "unpackfile=" + name+ "\">Unpack</a>";
								//else 
									elink = ahref + "file=" + name + "\" target=\"_blank\">View</a>";
							}
							else { // If the file cannot be edited
								//If it is a zip or jar File you can unpack it
								//if (isPacked(name, true)) 
								//	elink = ahref + "unpackfile=" + name + "\">Unpack</a>";
								//else 
								elink = ahref + "file=" + name + "\">View</a>";
							}
						}
						else {
							link = buf;
						}
					}
					String date = dateFormat.format(new Date(entry[i].lastModified()));
			%>		
					<tr class="mouseout" onmouseup="selrow(this, 2)" onmouseover="selrow(this, 0);" onmouseout="selrow(this, 1)">
			<%		
					if (entry[i].canRead()) {
			%>
						<td align=center width="10px"><input type="checkbox" class="checkbox" name="selfile" value="<%=name%>" onmousedown="dis()"></td>
			<%
					}else {
			%>		
						<td align=center width="10px"><input type="checkbox" class="checkbox" name="selfile" disabled></td>
			<%
					}
					String root = application.getRealPath("");
					root = URLEncoder.encode(root, "ISO-8859-1");
					
					root = root.replaceAll(URLEncoder.encode("\\","ISO-8859-1"), URLEncoder.encode("/","ISO-8859-1"));
					String pathFile = name.replaceAll(URLEncoder.encode("\\","ISO-8859-1"), URLEncoder.encode("/","ISO-8859-1"));
					
					int idx = pathFile.indexOf(root) ;
					if(idx > -1)
						pathFile = pathFile.substring(idx+ root.length());
						
					if(entry[i].isFile() ){
			%>
						<td align=left width="280px">&nbsp;<a href="javascript:returnFilePath('<%= ""+request.getAttribute("EltID") %>','<%= pathFile %>');" ><%=buf%></a></td>
			<%
					}else{
			%>
						<td align=left width="280px">&nbsp;<%=link %></td>		
			<%		
					}
					if (entry[i].isDirectory()){
			%>
					 	<td width="70px">&nbsp;</td>
			<%
					}else {
			%>
						<td width="70px" align=right title="<%= entry[i].length() + " bytes" %>">
								<%= convertFileSize(entry[i].length()) %>
						</td>
			<%
					}
					out.println("<td align=\"center\" width=\"40px\">" + type + "</td><td align=left width=\"155px\">&nbsp;" + date + "</td>");
					if (!READ_ONLY)
						out.print ("<td width=\"40px\">" + elink + "</td>"); // The edit link (or view, depending)
					out.println("</tr>");
				}
			}%>
			</table>
			</div>
			</td>
			</tr>
	</table>
	<p>
	<% if (!READ_ONLY) {%>
			<input title="Delete all selected files and directories incl. subdirs" class="button"  id="but_Del" type="Submit" name="Submit" value="<%=DELETE_FILES%>"
			onclick="return confirm('Do you really want to delete the entries?')">
	<%} %>
	</p>	
	<p align=center>
		<%
			Map<String, String> params = new HashMap<String,String>();
			params.put("sort", sortMode+"");
			params.put("FileType", typeFile);
			params.put("EltID", eltID);
		%>
		<b title="<%=totalSize%> bytes">
		<%=convertFileSize(totalSize)%></b><b> in <%=fileCount%> files in <%= dir2linkdir((String) request.getAttribute("dir"), browser_name, params)%>
		</b>
	</p>
		<input type="hidden" name="dir" value="<%=request.getAttribute("dir")%>">
		<input type="hidden" name="sort" value="<%=sortMode%>">

	<% if (!READ_ONLY) {%>
	<br />
		<input title="Enter new dir or filename or the relative or absolute path" class="textfield" type="text" onKeypress="event.cancelBubble=true;" id="text_Dir" name="cr_dir">
		<input title="Create a new directory with the given name" class="button" id="but_NDi" type="Submit" name="Submit" value="<%=CREATE_DIR%>">
		<input title="Move selected files and directories to the entered path" id="but_Mov" class="button" type="Submit" name="Submit" value="<%=MOVE_FILES%>">
		<input title="Copy selected files and directories to the entered path" id="but_Cop" class="button" type="Submit" name="Submit" value="<%=COPY_FILES%>">
	<% } %>
	</form>
	<br />
	<div class="formular">
	<% if (ALLOW_UPLOAD) { %>
	<form class="formular2" action="/browser/ServerBrowser.jsp" enctype="multipart/form-data" method="POST">
		<input type="hidden" name="dir" value="<%=request.getAttribute("dir")%>">
		<input type="hidden" name="sort" value="<%=sortMode%>">
		
		<input type="hidden" name="FileType" value="<%= request.getAttribute("FileType") %>" >
		<input type="hidden" name="EltID" value="<%= request.getAttribute("EltID") %>" >
		
		<input type="file" class="textfield" onKeypress="event.cancelBubble=true;" name="myFile" size="50%">
		<input title="Upload selected file to the current working directory" type="Submit" class="button" name="Submit" value="<%=UPLOAD_FILES%>" >
	</form>
	<%} %>
    </div>
    <%}%>
	<hr>
	<center>
		<small>Ph&#225;t tri&#7875;n t&#7915; jsp File Browser version <%= VERSION_NR%> c&#7911;a <a href="http://www.vonloesch.de">www.vonloesch.de</a></small>
	</center>
</body>
</html><%
    }
%>