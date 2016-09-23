package com.ufo.entity;

/**
 * Created on 2016/8/3.
 */
public class QueueInfo {
    private long id;
    private String queueName;
    private String exchangeName;
    private String routingKey;
    private byte exchangeType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public byte getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(byte exchangeType) {
        this.exchangeType = exchangeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueueInfo queueInfo = (QueueInfo) o;

        if (id != queueInfo.id) return false;
        if (exchangeType != queueInfo.exchangeType) return false;
        if (queueName != null ? !queueName.equals(queueInfo.queueName) : queueInfo.queueName != null) return false;
        if (exchangeName != null ? !exchangeName.equals(queueInfo.exchangeName) : queueInfo.exchangeName != null)
            return false;
        if (routingKey != null ? !routingKey.equals(queueInfo.routingKey) : queueInfo.routingKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (queueName != null ? queueName.hashCode() : 0);
        result = 31 * result + (exchangeName != null ? exchangeName.hashCode() : 0);
        result = 31 * result + (routingKey != null ? routingKey.hashCode() : 0);
        result = 31 * result + (int) exchangeType;
        return result;
    }
}
