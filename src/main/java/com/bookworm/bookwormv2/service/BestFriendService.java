package com.bookworm.bookwormv2.service;

import com.bookworm.bookwormv2.dto.FriendDTO;
import com.bookworm.bookwormv2.models.BestFriends;
import com.bookworm.bookwormv2.repository.BestFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestFriendService {

    @Autowired
    private BestFriendRepository bestFriendRepository;

    public List<FriendDTO> getFriendsForUser(Long userId){

        //-- Find all whether user or Friend in the best friend repo.
        List<BestFriends> bestFriends = bestFriendRepository.findBestFriendsByFriend_IdOrUser_Id(userId, userId);
        //-- New List based on the DTO
        List<FriendDTO> friendDTOs = new ArrayList<>();

        for (BestFriends bff : bestFriends){
            //-- Searching for whether are you user or friend columns in the entity.
            String friendUsername = bff.getUser().getId().equals(userId) ? bff.getFriend().getUsername() : bff.getUser().getUsername();
            //-- Now passing the Username and status to the DTO
            FriendDTO dto = new FriendDTO(friendUsername, bff.getStatus());
            //-- Results of DTO and now added.
            friendDTOs.add(dto);
        }
        return friendDTOs;
    }

}
