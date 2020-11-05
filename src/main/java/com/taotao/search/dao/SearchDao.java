package com.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.common.pojo.SearchResult;


/**
 * 访问solr的dao层
* <p>Title: SearchDao.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-18_00:04:30
* @version 1.0
 */
public interface SearchDao {

	public SearchResult search(SolrQuery query) throws Exception;
}
