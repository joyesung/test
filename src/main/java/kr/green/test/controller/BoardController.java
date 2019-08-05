package kr.green.test.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.MemberService;
import kr.green.test.service.PageMakerService;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	PageMakerService pageMakerService;
	
	@RequestMapping(value= "/board/list",method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri) throws Exception{
	  String valid = "i";
	  int displayPageNum = 10;
	  ArrayList<BoardVO> list = boardService.getBoardList(cri, "i");
	  int totalCount = boardService.getTotalCount(cri, valid);
	  PageMaker pm = pageMakerService.getPageMaker(displayPageNum, cri, totalCount);
	  System.out.println(pm);
	  mv.setViewName("/board/list");
	  mv.addObject("list", list);
	  mv.addObject("pageMaker", pm);
	  return mv;
	}
}
  