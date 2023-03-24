package com.kosa.myapp3.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.myapp3.comment.CommentDto;
import com.kosa.myapp3.comment.CommentService;
import com.kosa.myapp3.common.CommonConst;
import com.kosa.myapp3.common.FileUploadUtil;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	BoardService service;
	
	@Resource(name="commentService")
	CommentService c_service;
	
	@RequestMapping(value="/board/list")
	public String getList(BoardDto dto, Model model) {
		model.addAttribute("totalCnt", service.Board_getTotalCnt(dto));
		model.addAttribute("boardList", service.Board_getList(dto));
		
		return"board/board_list";
	}
	
	@RequestMapping(value="/board/write")
	public String boardWrite(Model model) {
		BoardDto tempDto = new BoardDto();
		model.addAttribute("boardDto", tempDto);
		
		return "board/board_write";
	}
	
	@RequestMapping(value="/board/modify")
	public String boardUpdate(BoardDto dto, Model model) {
		BoardDto tempDto = service.Board_getView(dto);
		model.addAttribute("boardDto", tempDto);
		
		return "board/board_write";
	}
	
	@ResponseBody
	@RequestMapping(value="/board/modify_save")
	public Map<String, String> boardUpdateSave(BoardDto dto, String []del, String []old_name, 
			MultipartHttpServletRequest multi) {
		Map<String, String> map = new HashMap<String, String>();
		//파일 첨부를 하지 않더라도 본래의 파일명은 갖고 있어야 한다.
		//디비에서 가져온 기본값을 넣어놓자
		dto.setFilename1(old_name[0]);
		dto.setFilename2(old_name[1]);
		dto.setFilename3(old_name[2]);
		
		String path =CommonConst.UPLOAD_PATH+"/board";
		FileUploadUtil.setFilePath(path);
		
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(multi.getFile("file1"));
		fileList.add(multi.getFile("file2"));
		fileList.add(multi.getFile("file3"));
		
		List<String> fileNameList = new ArrayList<String>();
		
		FileUploadUtil.upload(fileList, fileNameList);
		
		//첨부된 파일 처리하기
			if(del[0].equals("1"))
				dto.setFilename1(fileNameList.get(0));
			if(del[1].equals("2"))
				dto.setFilename2(fileNameList.get(1));
			if(del[2].equals("3"))
				dto.setFilename3(fileNameList.get(2));
			service.Board_update(dto);
			map.put("result", "success");
			
		return map;
	}
	
	//view(seq) ->reply(seq)
	@RequestMapping(value="/board/reply")
	public String boardReply(BoardDto dto, Model model) {
		//부모글 정보 가져오기
		BoardDto tempDto = service.Board_getView(dto);
		tempDto.setTitle("");		
		tempDto.setUserid("");		
		tempDto.setContents("");	
		model.addAttribute("boardDto", tempDto);
		
		return "board/board_write";
	}
	
	//ajax로 대답해야함
	@ResponseBody
	@RequestMapping(value="/board/reply_save")
	public Map<String, String> boardReplySave(BoardDto dto, Model model, MultipartHttpServletRequest multi) {
		Map<String, String> map = new HashMap<String, String>();
		
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(multi.getFile("file1"));
		fileList.add(multi.getFile("file2"));
		fileList.add(multi.getFile("file3"));
		
		List<String> fileNameList = new ArrayList<String>();
		//파일 업로드 경로 지정
		String path =CommonConst.UPLOAD_PATH+"/board";
		FileUploadUtil.setFilePath(path);
		FileUploadUtil.upload(fileList, fileNameList);
		
		dto.setFilename1(fileNameList.get(0));
		dto.setFilename2(fileNameList.get(1));
		dto.setFilename3(fileNameList.get(2));
		//트랜잭션 처리를 해놓으면 컨트롤러에서 예외처리를 해줘야함
		//서비스에서 예외처리를 하면 rollback이 적용이 안된다.
		try {
			service.Board_reply(dto);
			map.put("result", "success");
		} catch (Exception e) {
			map.put("result", "fail");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/board/save")
	public Map<String, String> boardSave(BoardDto dto, MultipartHttpServletRequest multi) {
		//ddt에 다른 파라미터값들은 이미 들어와있음
		//파일처리만 하면 된다.
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(multi.getFile("file1"));
		fileList.add(multi.getFile("file2"));
		fileList.add(multi.getFile("file3"));
		
		List<String> fileNameList = new ArrayList<String>();
		
		//파일 업로드 경로 지정
		String path =CommonConst.UPLOAD_PATH+"/board";
		FileUploadUtil.setFilePath(path);
		FileUploadUtil.upload(fileList, fileNameList);
		
		switch (fileNameList.size()) {
		case 2:
			dto.setFilename3(fileNameList.get(2));
		case 1:
			dto.setFilename2(fileNameList.get(1));
		case 0:
			dto.setFilename1(fileNameList.get(0));
		}
		
		service.Board_insert(dto);
		
		Map<String, String> resultmap = new HashMap<String, String>();
		resultmap.put("result", "success");
		
		return resultmap;
	}
	
	@RequestMapping(value="/board/view")
	public String boardView(BoardDto dto, Model model){
		
		CommentDto c_dto = new CommentDto();
		c_dto.setBoard_seq(dto.getSeq());
		System.out.println(dto.getSeq());
		service.Board_hit(dto);
		model.addAttribute("view", service.Board_getView(dto));
		model.addAttribute("comment_list", c_service.Comment_getList(c_dto));
		
		return "board/board_view";
	}
	
	//원래글이 있고 여기에 별도로 코맨트를 달거나 추천을 할 때 그 부분만 별도의 움직임이 있어야한다.
	//ajax말고 방법이 없다.
	@ResponseBody
	@RequestMapping(value="/board/commentsave")
	public Map<String, Object> commentSave(CommentDto c_dto){
		Map<String, Object> resultmap = new HashMap<String, Object>();
		//map<키값, 저장할 데이터> 키값은 거의 항상 String 이지만 저장 할 데이터는 String이 아닌 객체일 수도 있어서 Object로 한다.
		c_service.Comment_insert(c_dto);
		resultmap.put("result", "success");
		
		return resultmap;
	}
	
	@ResponseBody
	@RequestMapping(value="/board/delete")
	public Map<String, String> boardDelete(BoardDto dto, Model model) {
		Map<String, String> resultMap = new HashMap<String, String>();
		service.Board_delete(dto);
		resultMap.put("result", "success");
		
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value="board/commentdelete")
	public Map<String, Object> commentDelete(CommentDto c_dto){
		Map<String, Object> resultmap = new HashMap<String, Object>();
		c_service.Comment_delete(c_dto);
		resultmap.put("result", "succescc");
		resultmap.put("seqq", c_dto.getSeq());
		return resultmap;
	}
	
	
}

