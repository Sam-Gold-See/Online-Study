package com.study.constant;

/**
 * 通知常量类
 */
public class NotificationConstant {

    // 通知类型为点赞
    public static final Integer LIKE = 1;

    // 通知类型为评论
    public static final Integer COMMENT = 2;

    // 通知类型为回复
    public static final Integer REPLY = 3;

    // 点赞帖子通知内容
    public static final String LIKE_POST_NOTIFICATION = "您的帖子收到了一条点赞";

    // 点赞评论通知内容
    public static final String LIKE_COMMENT_NOTIFICATION = "您的评论收到了一条点赞";

    // 评论通知内容
    public static final String COMMENT_NOTIFICATION = "您的帖子收到了一条评论";

    // 回复通知内容
    public static final String REPLY_NOTIFICATION = "您的评论收到了一条回复";
}
