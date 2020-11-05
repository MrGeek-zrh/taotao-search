package com.mrgeek.test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * solr单机版 客户端测试
* <p>Title: SolrJTest.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-17_20:42:52
* @version 1.0
 */
public class SolrJTest {

	/**
	 * 向索引库中添加数据
	* <p>Title: testDolrJ<／p>
	* <p>Description: <／p>
	* @throws Exception
	 */
	@Test
	public void testSolrJCommit() throws Exception {
		//创建连接
		SolrServer solrServer = new HttpSolrServer("http://112.124.28.54:8080/solr");
		//创建一个文档对象,即一个数据源
		SolrInputDocument document = new SolrInputDocument();
		//添加数据
		document.addField("id", "solrtest01");
		document.addField("item_title", "测试商品");
		document.addField("item_sell_point", "卖点");
		//添加到索引库
		solrServer.add(document);
		//提交
		solrServer.commit();
	}
	
	/**
	 * 从索引库中查询数据
	* <p>Title: testSolrJQuery<／p>
	* <p>Description: <／p>
	* @throws Exception
	 */
	@Test
	public void testSolrJQuery() throws Exception {
		//创建连接
		SolrServer solrServer = new HttpSolrServer("http://112.124.28.54:8080/solr");
		//创建一个查询对象
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		//执行查询
		QueryResponse response = solrServer.query(query);
		//获取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_sell_point"));
		}
	}
}
