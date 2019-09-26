package com.trilogyed.commentqueueconsumer;

import com.trilogyed.commentqueueconsumer.model.Comment;
import com.trilogyed.commentqueueconsumer.util.feign.CommentClient;
import com.trilogyed.commentqueueconsumer.util.messages.CommentEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageListener {
    @Autowired
    CommentClient commentClient;

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveComment(CommentEntry commentEntry) {
        try {
            if (commentEntry.getCommentId() == 0) {
                Comment comment = new Comment();
                comment.setPostId(commentEntry.getPostId());
                comment.setCreateDate(commentEntry.getCreateDate());
                comment.setCommenterName(commentEntry.getCommenterName());
                comment.setComment(commentEntry.getComment());
                commentClient.createComment(comment);

            } else {
                Comment comment = new Comment();
                comment.setCommentId(commentEntry.getCommentId());
                comment.setPostId(commentEntry.getPostId());
                comment.setCreateDate(commentEntry.getCreateDate());
                comment.setCommenterName(commentEntry.getCommenterName());
                comment.setComment(commentEntry.getComment());
                commentClient.updateComment(commentEntry.getCommentId(),comment);
            }
        } catch (Exception e) {
            System.out.println("There is an exception: " + e.getMessage());
        }
    }
}
