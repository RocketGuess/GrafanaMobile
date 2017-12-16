package com.gogisoft.grafanamobile.panels;

import com.gogisoft.grafanamobile.api_client.models.Target;

public class TargetWrapper {
    public enum TargetType {
        Prometheus,
        Unknow
    }

    private Target target;
    public TargetWrapper(Target target) {
        this.target = target;
    }

    public TargetType getTargetType() {
        if (this.target.getExpr() != null) {
            return TargetType.Prometheus;
        } else {
            return TargetType.Unknow;
        }
    }

    public Target getTarget() {
        return this.target;
    }
}
