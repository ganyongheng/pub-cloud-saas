package com.pub.core.common;

public interface OfflineConstants {

    public interface blockStatus {
        public static final Integer block_no=9;
        public static final Integer block=-1;
    }
    public interface offlineRole {
        //客服
        public static final Integer customer=2;
        //系统管理员
        public static final Integer system=1;
    }
    public interface deleteStats {
        public static final Integer delete_no=9;
        public static final Integer delete=-1;
    }
    public interface orderStats {
        public static final Integer initial =0;
        public static final Integer error=-1;
        public static final Integer finish=1;
    }
    public interface checkStatus {
        public static final Integer check=9;
        public static final Integer check_no=-1;
    }

}
