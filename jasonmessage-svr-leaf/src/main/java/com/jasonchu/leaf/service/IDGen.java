package com.jasonchu.leaf.service;


import com.jasonchu.leaf.common.Result;

/**
 * @author leaf
 */
public interface IDGen {

	/**
	 * get
	 * @param key key
	 * @return Result
	 */
	Result get(String key);

	/**
	 * init
	 * @return inited
	 */
	boolean init();

}
