package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.SearchResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.search.service.SearchService;

/**
 * 发布搜索功能的服务
* <p>Title: SearchController.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-18_09:48:40
* @version 1.0
 */
@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/q")
	@ResponseBody
	public TaotaoResult search(
			@RequestParam(defaultValue="")String keyword, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="30")Integer rows) {
		
		try {
			//转换字符集,用于处理get乱码（这里的乱码是get乱码，不是post乱码）
			keyword = new String(keyword.getBytes("ISO-8859-1"), "utf-8");
			SearchResult searchResult = searchService.searchResult(keyword, page, rows);
			return TaotaoResult.ok(searchResult);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
	}

}