package kr.green.test.service;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;

public interface PageMakerService {

	PageMaker getPageMaker(int displayPageNum, Criteria cri, int totalCount);

}
