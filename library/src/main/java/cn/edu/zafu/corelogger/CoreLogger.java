package cn.edu.zafu.corelogger;

/**
 * User:lizhangqu(513163535@qq.com)
 * Date:2015-11-08
 * Time: 11:31
 */
public interface CoreLogger {
    enum CoreLogLevel {
        DEBUG(1), INFO(2), WARNING(3), ERROR(4);
        private int level;

        CoreLogLevel(int level) {
            this.level = level;
        }

        public int getLevel(){
            return this.level;
        }

        public static CoreLogLevel getValue(int level){
            for (CoreLogLevel l:CoreLogLevel.values()){
                if (l.getLevel()==level){
                    return l;
                }
            }
            return CoreLogLevel.DEBUG;
        }
    }

    void log(String msg,CoreLogLevel level);
    void log(String msg,CoreLogLevel level,Throwable throwable);
}
