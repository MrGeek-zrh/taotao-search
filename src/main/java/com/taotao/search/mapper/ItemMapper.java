package com.taotao.search.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.taotao.common.pojo.SearchItem;


/**
 * 商品Mapper
* <p>Title: ItemMapper.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-17_21:22:34
* @version 1.0
 */
@Repository
public interface ItemMapper {
	List<SearchItem> getItemList();
}
