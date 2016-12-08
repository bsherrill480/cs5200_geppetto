<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 12/6/16
  Time: 2:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<div id="sidebar-wrapper">
    <ul class="sidebar-nav ">
        <li class="sidebar-brand">
            <a href="/">
                <div class="logo">
                    <div>
                        <span class="logo__text">Geppetto</span>
                    </div>
                    <div>
                        <img class="logo__img" src="/img/gepetto_logo.png">
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="/lobbying">Lobbying</a>
        </li>
        <li>
            <ul class="sidebar-nav__sub-list">
                <li>
                    <a href="CampaignFinance/averageSpendingByIndustry">Average Spending By Industry</a>
                </li>
                <li>
                    <a href="Lobbying/topPaidLobbyFirms">Top Paid Lobby Firms</a>
                </li>
                <li>
                    <a href="Lobby/orgsPayingForLobbying">Organizations Paying for Lobbying</a>
                </li>
                <li>
                    <a href="#">Top Lobbied Issues</a>
                </li>
                <li>
                    <a href="#">Former Congress-Member Lobbyists</a>
                </li>
                <li>
                    <a href="#">Top Lobbied Bills</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="/CampaignFinance">Campaign Finance</a>
        </li>
        <li>
            <ul class="sidebar-nav__sub-list">
                <%--If we have time--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                         <%--Search Candidates--%>
                    <%--</a>--%>
                <%--</li>--%>
                <li>
                    <a href="/CampaignFinance/IndividualsDonatingTheMost">
                        Individuals Donating The Most
                    </a>
                </li>
                <li>
                    <a href="/CampaignFinance/CandidatesReceivingPacMoney">Candidates Receiving Pac Money</a>
                </li>
                <li>
                    <a href="/CampaignFinance/TopIndustryDonors">Top Industry Donors</a>
                </li>
                <li>
                    <a href="/CampaignFinance/IndividualDonations/AverageToCandidate">Average Individual Donations</a>
                </li>
                <li>
                    <a href="/CampaignFinance/IndividualDonations/DonationCounts">Candidates By Donations</a>
                </li>
                <li>
                    <a href="/CampaignFinance/PacDonations/AverageToCandidate">Average Donation From Pacs</a>
                </li>
            </ul>
        </li>
    </ul>
</div>
