package com.taotao.search.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.service.ItemService;

/**
 * 导入商品功能实现类
* <p>Title: ItemServiceImpl.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-17_21:54:48
* @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private SolrServer solrServer;
	
	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 将数据库中的数据导入索引库
	 * @throws Exception 
	 */
	@Override
	public TaotaoResult importItems() throws Exception {
		//查询数据库获取商品列表
		List<SearchItem> list = itemMapper.getItemList();
		
		//遍历列表，将数据存入document中
		for (SearchItem item : list) {
			//创建document对象
			SolrInputDocument document = new SolrInputDocument();
			//添加域
			document.addField("id", item.getId());
			document.addField("item_title", item.getTitle());
			document.addField("item_sell_point", item.getSell_point());
			document.addField("item_price", item.getPrice());
			document.addField("item_image", item.getImage());
			document.addField("item_category_name", item.getCategory_name());
			document.addField("item_desc", item.getItem_desc());
			//写入索引库
			solrServer.add(document);
		}
		//提交
		solrServer.commit();
		return TaotaoResult.ok();
	}

}
