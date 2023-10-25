package mqq.app.api;

import mqq.app.AppRuntime;

public interface IRuntimeService {
    void onCreate(AppRuntime appRuntime);

    void onDestroy();
}