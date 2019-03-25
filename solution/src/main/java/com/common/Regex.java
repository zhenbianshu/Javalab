package com.common;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * created by xiepengfei on 2018/12/10
 */
public class Regex {
    private static final Pattern uploadInfoPattern = compile("^[^|]*\\|(.*)$");
    public static void main(String[] args) {
        Pattern IPHONE_MODEL_PATTERN = compile("(iPhone)?(\\d+),(\\d+)");

        System.out.println(IPHONE_MODEL_PATTERN.matcher("iPhone5,2").matches());
        System.out.println(IPHONE_MODEL_PATTERN.matcher("5,2").matches());

        String line = "10.41.21.78|{\"@timestamp\":\"2018-11-26T12:23:28+08:00\", \"act\": \"upstream\", \"discovery_ssc\": 0, \"short_url\": \"\", \"upload_file_path\": \"\\/storage\\/emulated\\/0\\/sina\\/weibo\\/.weibo_pic_edit_cache\\/1543206129782_9d69a63d-bcdd-4ab7-bd3b-8a992afb3176_by_revision.jpg\", \"networktype\": \"4g\", \"origin_md5\": \"1b39bc04498b5bd1c5dcbe6ae7686bf7\", \"discovery_total_time\": 208, \"start_date\": 1543206131059, \"upload_retry_count\": 0, \"chunk_size\": 122880, \"upload_codec_concurrent_enable\": true, \"upload_speed\": 54, \"file_type\": \"pic\", \"discovery_time\": 0.208, \"upload_https_enable\": true, \"client_mblogid\": \"84d4f9ce-7723-4224-9a1e-a8fecc56a0c6\", \"origin_md5_time\": 1, \"is_canceled\": false, \"file_id\": \"006UarLRgy1fxlcjb8b77j30k00u076b\", \"total_time\": 1.54, \"upload_chunk_speed\": \"97\", \"origin_file_name\": \"img-bf68fa2410f0fe9796c7357b4847dcd2.jpg\", \"origin_file_path\": \"\\/storage\\/emulated\\/0\\/sina\\/weibo\\/weibo\\/img-bf68fa2410f0fe9796c7357b4847dcd2.jpg\", \"upload_strategy_type\": 0, \"total_speed\": 54, \"is_success\": true, \"init_time\": 0.392, \"chunk_info_type\": 6, \"ap\": \"ctnet\", \"dns\": \"\", \"idc\": \"\", \"rtt\": 148, \"from\": \"108B295010\", \"upload_concurrent_count\": -1, \"origin_length\": 85180, \"discovery_host_ip\": \"180.149.153.242\", \"upload_720p_enable\": false, \"business_type\": \"composer\", \"upload_cronet_enable\": false, \"upload_length\": 85180, \"upload_time\": 1.54, \"upload_uuid\": \"7cbe3b92-4596-42aa-a1a8-345523de4819\", \"upload_pre_discovery_enable\": false, \"md5_time\": 1, \"discovery_dl\": 0, \"discovery_rb\": 1, \"discovery_sc\": 0, \"discovery_sr\": 1, \"discovery_ws\": 190, \"upload_id\": \"1b39bc04498b5bd1c5dcbe6ae7686bf7\", \"createtype\": \"localfile\", \"origin_file_dir\": \"\\/storage\\/emulated||||\\/0\\/sina\\/weibo\\/weibo\", \"bussiness_id\": \"84d4f9ce-7723-4224-9a1e-a8fecc56a0c6\", \"current_upload_length\": 85180, \"end_date\": 1543206132595, \"file_length\": 85180, \"seg_num\": 1, \"file_token\": \"6326761843.1b39bc04498b5bd1c5dcbe6ae7686bf7.85180.120.1543206131.pic\", \"ua\": \"vivo-vivo Y85__weibo__8.11.2__android__android8.1.0\", \"wm\": \"9856_0004\", \"uid\": \"6326761843\", \"ip\": \"106.61.78.175\", \"date\": \"2018-11-26 12:23:28\", \"sessionid\": \"a8817dc1-c582-4f82-83df-4016b01c51a0\" }";

        System.out.println(getJson(line).get("file_type"));
        System.out.println(getJson(line).get("discovery_time"));
    }

    private static Map<String, Object> getJson(String line) {
        Matcher matcher = uploadInfoPattern.matcher(line);
        if (!matcher.find()) {
            return null;
        }
        String uploadInfo = matcher.group(1);
        Map<String, Object> json;
        try {
            json = GsonUtil.fromJson(uploadInfo, GsonUtil.GsonType.OBJECT_MAP_TYPE);
        } catch (Exception e) {
            return null;
        }
        return json;
    }

}
