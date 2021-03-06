/**
 * ##########################  GoodCrawler  ############################
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sbs.goodcrawler.bootstrap.foreman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.sbs.goodcrawler.extractor.DefaultExtractWorker;
import org.sbs.goodcrawler.extractor.DefaultExtractor;
import org.sbs.goodcrawler.jobconf.ExtractConfig;

/**
 * @author shenbaise(shenbaise@outlook.com)
 * @date 2013-7-3
 * 提取工工头
 */
public class ExtractForeman extends Foreman{
	
	public void start(ExtractConfig conf){
		int threadNum = conf.getThreadNum();
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);
		for(int i=0;i<threadNum;i++){
			executor.submit(new DefaultExtractWorker(conf,new DefaultExtractor(conf)));
		}
		executor.shutdown();
	}
}
