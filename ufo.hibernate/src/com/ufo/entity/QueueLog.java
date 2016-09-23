package com.ufo.entity;

/**
 * Created on 2016/8/3.
 */
public class QueueLog {
    private long id;
    private String ip;
    private String queueName;
    private String exchangeName;
    private String routingKey;
    private String className;
    private String context;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueueLog log = (QueueLog) o;

        if (id != log.id) return false;
        if (ip != null ? !ip.equals(log.ip) : log.ip != null) return false;
        if (queueName != null ? !queueName.equals(log.queueName) : log.queueName != null) return false;
        if (exchangeName != null ? !exchangeName.equals(log.exchangeName) : log.exchangeName != null) return false;
        if (routingKey != null ? !routingKey.equals(log.routingKey) : log.routingKey != null) return false;
        if (className != null ? !className.equals(log.className) : log.className != null) return false;
        if (context != null ? !context.equals(log.context) : log.context != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (queueName != null ? queueName.hashCode() : 0);
        result = 31 * result + (exchangeName != null ? exchangeName.hashCode() : 0);
        result = 31 * result + (routingKey != null ? routingKey.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        return result;
    }
}
