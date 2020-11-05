package com.taotao.search.service;

import com.taotao.common.pojo.SearchResult;

/**
 * 搜索功能Service类
* <p>Title: SearchService.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-18_01:25:40
* @version 1.0
 */
public interface SearchService {

	SearchResult searchResult(String queryString,int page,int rows) throws Exception;
}
