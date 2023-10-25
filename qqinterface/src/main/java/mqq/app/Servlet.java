package mqq.app;

import android.content.Intent;

public abstract class Servlet {
    private ServletContainer container;
    private AppRuntime mAppRuntime;

    public AppRuntime getAppRuntime() {
        return this.mAppRuntime;
    }

    ServletContainer getServletContainer() {
        return this.container;
    }

    public abstract void service(Intent intent);

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void init(AppRuntime appRuntime, ServletContainer servletContainer) {
        this.mAppRuntime = appRuntime;
        this.container = servletContainer;
    }
}
