import * as React from 'react';
import { AppBar, AppBarSection, AppBarSpacer, Avatar } from '@progress/kendo-react-layout';
import { Badge, BadgeContainer } from '@progress/kendo-react-indicators';
import { bellIcon, menuIcon } from '@progress/kendo-svg-icons';
import { Button } from '@progress/kendo-react-buttons';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DrawerRouterContainer from './DrawerRouterContainer';
import LoanView from '../../domain/loan/LoanView';
import '../../App.scss';
// import '../../themes/kendo-theme-custom.sccs';


const kendokaAvatar = 'https://demos.telerik.com/kendo-react-ui/assets/suite/kendoka-react.png';

const MainLayout = () => {

    return (
		<>
        <BrowserRouter>
			<AppBar>
			<AppBarSection>
					<Button type="button" fillMode="flat" svgIcon={menuIcon} />
				</AppBarSection>

				<AppBarSpacer style={{ width: 4 }} />

				<AppBarSection>
					<h1 className="title">MCLS</h1>
				</AppBarSection>

				<AppBarSpacer />

				<AppBarSection>
					<ul>
						<li>
							<span>What's New</span>
						</li>
					</ul>
				</AppBarSection>

				<AppBarSpacer style={{ width: 16 }} />

				<AppBarSection className="actions">
					<Button type="button" fillMode="flat" svgIcon={bellIcon}>
						<BadgeContainer>
							<Badge rounded="full" themeColor="info" size="small" position="inside" />
						</BadgeContainer>
					</Button>
				</AppBarSection>

				<AppBarSection>
					<span className="k-appbar-separator" />
				</AppBarSection>

				<AppBarSection>
					<Avatar type="image">
						<img src={kendokaAvatar} alt="KendoReact Layout Kendoka Avatar" />
					</Avatar>
				</AppBarSection>
			</AppBar>
			<style>{`
                body {
                    background: #dfdfdf;
                }
                .title {
                    font-size: 18px;
                    margin: 0;
                }
                ul {
                    font-size: 14px;
                    list-style-type: none;
                    padding: 0;
                    margin: 0;
                    display: flex;
                }
                li {
                    margin: 0 10px;
                }
                li:hover {
                    cursor: pointer;
                    color: #84cef1;
                }
                .k-badge-container {
                    margin-right: 8px;
                }
            `}</style>
        	<DrawerRouterContainer>
           		<Routes>
					<Route path="" element={<LoanView />} />
           		</Routes>
        	</DrawerRouterContainer>
        </BrowserRouter>
		</>
    );
};

export default MainLayout;

/*
import Inbox from './Inbox';
import Notifications from './Notifications';
import Calendar from './Calendar';
import Attachments from './Attachments';
import Favourites from './Favourites';

                <Route path="/" element={<Inbox />} />
                <Route path="/notifications" element={<Notifications />} />
                <Route path="/calendar" element={<Calendar />} />
                <Route path="/attachments" element={<Attachments />} />
                <Route path="/favourites" element={<Favourites />} />
*/
